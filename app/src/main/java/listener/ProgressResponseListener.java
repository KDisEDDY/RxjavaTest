package listener;

/**
 * Title: listener.ProgressResponseListener
 * Description: 用于进度监听的监听器
 * Copyright: Copyright (c) 2014-2016 gjfax.com
 * Company: 广金所
 * Author: 刘加彦
 * Date: 2017/2/22
 * Version: 1.0
 */
public interface ProgressResponseListener {
    void onResponseProgress(long bytesRead, long contentLength, boolean done);
}
