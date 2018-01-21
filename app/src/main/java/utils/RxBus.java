package utils;

/**
 * Title: RxBus
 * Description:Rxjava实现事件总线功能
 * Copyright: Copyright (c) 2014-2016 gjfax.com
 * Company: 广金所
 * Created by YoKeyword on 2015/6/17.
 * Date: 2017/2/8
 * Version: 1.0
 */


import org.reactivestreams.Subscriber;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

/**
 * RxBus
 */
public class RxBus {
    private static volatile RxBus mDefaultInstance;

    private final Subject<Object> mBus;

    private final Map<Class<?>,Object> mStickyMap;

    public RxBus() {
        // PublishSubject只会把在订阅发生的时间点之后来自原始Observable的数据发射给观察者
        mBus = PublishSubject.create().toSerialized();
        //利用map来保存sticky事件
        mStickyMap = new ConcurrentHashMap<>();
    }
    // 单例RxBus
    public static RxBus getDefault() {
        if (mDefaultInstance == null) {
            synchronized (RxBus.class) {
                if (mDefaultInstance == null) {
                    mDefaultInstance = new RxBus();

                }
            }
        }
        return mDefaultInstance;
    }
    // 发送一个新的事件
    public void post (Object o) {
        mBus.onNext(o);
    }

    // 根据传递的 eventType 类型返回特定类型(eventType)的 被观察者
    public <T> Observable<T> toObservable (Class<T> eventType) {
        return mBus.ofType(eventType);

//        这里感谢小鄧子的提醒: ofType = filter + cast
//        return mBus.filter(new Func1<Object, Boolean>() {
//            @Override
//            public Boolean call(Object o) {
//                return eventType.isInstance(o);
//            }
//        }) .cast(eventType);
    }

    public void postSticky(Object event) {
        synchronized (mStickyMap) {
            mStickyMap.put(event.getClass(), event);
        }
        post(event);
    }

    public <T> Observable<T> toObservableSticky(final Class<T> eventType) {
        synchronized (mStickyMap) {
            final Observable<T> observable = mBus.ofType(eventType);
            final Object event = mStickyMap.get(eventType);

            if (event != null) {
                return observable.mergeWith(new Observable<T>() {
                    @Override
                    protected void subscribeActual(Observer<? super T> observer) {
                        observer.onNext(eventType.cast(event));
                    }
                });
            } else {
                return observable;
            }
        }
    }

    /**
     * 移除所有的Sticky事件
     */
    public void removeAllStickyEvents() {
        synchronized (mStickyMap) {
            mStickyMap.clear();
        }
    }

    public <T>ConnectableObservable<T> subConnect(Class<T> eventType){
        return mBus.ofType(eventType).publish().replay();
    }
}
