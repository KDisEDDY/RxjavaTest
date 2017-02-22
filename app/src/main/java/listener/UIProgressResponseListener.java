package listener;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import java.lang.ref.WeakReference;

import data.ProgressModel;

/**
 * Title: UIProgressResponseListener
 * Description:
 * Copyright: Copyright (c) 2014-2016 gjfax.com
 * Company: 广金所
 * Author: 刘加彦
 * Date: 2017/2/22
 * Version: 1.0
 */
public abstract class UIProgressResponseListener implements ProgressResponseListener{
    private static final int REQUEST_UPDATE = 0x01;

    private static class UIHandler extends Handler{

        //弱引用
        private final WeakReference<UIProgressResponseListener> mUIProgressResponseListener;

        public UIHandler(Looper looper, UIProgressResponseListener uiProgressResponseListener) {
            super(looper);
            mUIProgressResponseListener = new WeakReference<>(uiProgressResponseListener);
        }

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case REQUEST_UPDATE:
                    UIProgressResponseListener uiProgressResponseListener = mUIProgressResponseListener.get();
                    if (uiProgressResponseListener != null) {
                        //获得进度实体类
                        ProgressModel progressModel = (ProgressModel) msg.obj;
                        //回调抽象方法
                        uiProgressResponseListener.onUIResponseProgress(progressModel.getCurrentBytes(), progressModel.getContentLength(), progressModel.isDone());
                    }
                    break;
                default:
                    super.handleMessage(msg);
                    break;
            }
        }
    }

    private UIHandler uiHandler = new UIHandler(Looper.getMainLooper(),this);

    @Override
    public void onResponseProgress(long bytesRead, long contentLength, boolean done) {
        //通过Handler发送进度消息
        Message message = Message.obtain();
        message.obj = new ProgressModel(bytesRead, contentLength, done);
        message.what = REQUEST_UPDATE;
        uiHandler.sendMessage(message);
    }

    public abstract void onUIResponseProgress(long bytesRead, long contentLength, boolean done);
}
