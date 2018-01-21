package project.ljy.rxjavatest;

import android.util.Log;

import org.junit.Test;

import event.CommonEvent;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.AsyncSubject;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;
import io.reactivex.subjects.Subject;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    private static final String TAG = "RxjavaLOG";

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void rx_publishSubjectTest() throws Exception{
        //PublishSubject
        //一次发送回调一次，切发送需在订阅后
        Subject publishSubject = PublishSubject.create().toSerialized();

        publishSubject.ofType(CommonEvent.class).subscribe(new Consumer<CommonEvent>() {
            @Override
            public void accept(CommonEvent o) throws Exception {
                if(o == CommonEvent.UPDATE_ARGMENT){
                    System.out.print( "rxjavaOutput----------------------------------UPDATE_ARGMENT");
                } else if( o == CommonEvent.UPDATE_LIST){
                    System.out.print("rxjavaOutput----------------------------------UPDATE_LIST");
                } else {
                    System.out.print("rxjavaOutput----------------------------------UPDATE_COMMENT");
                }
            }
        });
        publishSubject.onNext(CommonEvent.UPDATE_LIST);
    }

    @Test
    public void rx_behaviorSubjectTest() throws Exception{
        //BehaviorSubject
        //当订阅在发送后，会发送最后一次事件
        Subject subject = BehaviorSubject.create().toSerialized();
        subject.ofType(CommonEvent.class).subscribe(new Consumer<CommonEvent>() {
            @Override
            public void accept(CommonEvent o) throws Exception {
                if(o == CommonEvent.UPDATE_ARGMENT){
                    System.out.println("rxjavaOutput----------------------------------Subject1:UPDATE_ARGMENT");
                } else if( o == CommonEvent.UPDATE_LIST){
                    System.out.println("rxjavaOutput----------------------------------Subject1:UPDATE_LIST");
                } else {
                    System.out.println("rxjavaOutput----------------------------------Subject1:UPDATE_COMMENT");
                }
            }
        });
        subject.onNext(CommonEvent.UPDATE_LIST);
        subject.ofType(CommonEvent.class).subscribe(new Consumer<CommonEvent>() {
            @Override
            public void accept(CommonEvent o) throws Exception {
                if(o == CommonEvent.UPDATE_ARGMENT){
                    System.out.println( "rxjavaOutput----------------------------------Subject2:UPDATE_ARGMENT");
                } else if( o == CommonEvent.UPDATE_LIST){
                    System.out.println("rxjavaOutput----------------------------------Subject2:UPDATE_LIST");
                } else {
                    System.out.println("rxjavaOutput----------------------------------Subject2:UPDATE_COMMENT");
                }
            }
        });
    }

    @Test
    public void rx_replaySubjectTest() throws Exception{
        //BehaviorSubject
        //当订阅在发送后，会发送最后一次事件
        Subject subject = ReplaySubject.create().toSerialized();
        subject.onNext(CommonEvent.UPDATE_LIST);
        subject.onError(new Throwable());
        subject.onNext(CommonEvent.UPDATE_COMMENT);

        subject.ofType(CommonEvent.class).subscribe(new Consumer<CommonEvent>() {
            @Override
            public void accept(CommonEvent o) throws Exception {
                if(o == CommonEvent.UPDATE_ARGMENT){
                    System.out.println( "rxjavaOutput----------------------------------UPDATE_ARGMENT");
                } else if( o == CommonEvent.UPDATE_LIST){
                    System.out.println("rxjavaOutput----------------------------------UPDATE_LIST");
                } else {
                    System.out.println("rxjavaOutput----------------------------------UPDATE_COMMENT");
                }
            }
        });

    }

    @Test
    public void rx_asyncSubjectTest() throws Exception{
        //BehaviorSubject
        //当订阅在发送后，会发送最后一次事件
        Subject subject = AsyncSubject.create().toSerialized();
        subject.onNext(CommonEvent.UPDATE_LIST);
        subject.onNext(CommonEvent.UPDATE_COMMENT);

        subject.ofType(CommonEvent.class).subscribe(new Consumer<CommonEvent>() {
            @Override
            public void accept(CommonEvent o) throws Exception {
                if(o == CommonEvent.UPDATE_ARGMENT){
                    System.out.println( "rxjavaOutput----------------------------------UPDATE_ARGMENT");
                } else if( o == CommonEvent.UPDATE_LIST){
                    System.out.println("rxjavaOutput----------------------------------UPDATE_LIST");
                } else {
                    System.out.println("rxjavaOutput----------------------------------UPDATE_COMMENT");
                }
            }
        });
    }
}