package utils;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import listener.ProgressResponseListener;
import listener.UIProgressResponseListener;
import okhttp3.ResponseBody;
import callback.DownLoadCallBack;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Title: DownLoadUtil
 * Description:下载文件工具类
 * Copyright: Copyright (c) 2014-2016 gjfax.com
 * Company: 广金所
 * Author: 刘加彦
 * Date: 2017/2/20
 * Version: 1.0
 */
public class DownLoadUtil {

    final static int SUCCESS = 1;

    final static int FAILURE = 2;

    static Handler handler = new Handler(Looper.getMainLooper()){
        @Override
        public void handleMessage(Message msg) {
            DownLoadCallBack callback = (DownLoadCallBack) msg.obj;
            switch (msg.what){
                case SUCCESS:
                    callback.onSuccess();
                    break;
                case FAILURE:
                    callback.onFailure();
                    break;
            }
        }
    };

    private ProgressResponseListener listener ;

    public static void downloadFile(final String url , final DownLoadCallBack callBack){
        Call<ResponseBody> call =  RetrofitManager.getDownLoadApi().downLoadFile(url);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful()){
                    Observable.just(response.body())
                            .observeOn(Schedulers.io())
                            .subscribeOn(Schedulers.newThread())
                            .subscribe(new DisposableObserver<ResponseBody>() {
                                @Override
                                public void onNext(ResponseBody body) {
                                    String[] strArray = url.split("/");
                                    if(strArray[strArray.length -1] != null){
                                        try {
                                            String rootDir = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "RxjavaTest";
                                            File fileDir = new File(rootDir);
                                            if(!fileDir.exists()){
                                                fileDir.mkdirs();
                                            }
                                            File futureStudioIconFile = new File(rootDir + File.separator + strArray[strArray.length -1] );
                                            if(futureStudioIconFile.exists()){
                                                futureStudioIconFile.delete();
                                            }
                                            InputStream inputStream = null;
                                            OutputStream outputStream = null;

                                            try {
                                                byte[] fileReader = new byte[4096];

                                                inputStream = body.byteStream();
                                                outputStream = new FileOutputStream(futureStudioIconFile);

                                                while (true) {
                                                    int read = inputStream.read(fileReader);

                                                    if (read == -1) {
                                                        break;
                                                    }
                                                    outputStream.write(fileReader, 0, read);
                                                }

                                                outputStream.flush();
                                                handler.sendMessage(obtainMessage(SUCCESS,callBack));
                                            } catch (IOException e) {
                                                handler.sendMessage(obtainMessage(FAILURE,callBack));
                                            } finally {
                                                if (inputStream != null) {
                                                    inputStream.close();
                                                }

                                                if (outputStream != null) {
                                                    outputStream.close();
                                                }
                                            }
                                        } catch (IOException e) {
                                            handler.sendMessage(obtainMessage(FAILURE,callBack));
                                        }
                                    }
                                }

                                @Override
                                public void onError(Throwable e) {
                                    e.printStackTrace();
                                    handler.sendMessage(obtainMessage(FAILURE,callBack));
                                }

                                @Override
                                public void onComplete() {

                                }
                            });
                } else {
                    handler.sendMessage(obtainMessage(FAILURE,callBack));
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                handler.sendMessage(obtainMessage(FAILURE,callBack));
            }
        });
    }

    public static void downloadProgressFile(final String url, final UIProgressResponseListener listener){
        RetrofitManager.getDownLoadApi().downloadProgressFile(url)
                .observeOn(Schedulers.io())
                .subscribeOn(Schedulers.io())
                .map(new Function<ResponseBody, File>() {
                    @Override
                    public File apply(ResponseBody body) throws Exception {
                        String[] strArray = url.split("/");
                        File futureStudioIconFile = null;
                        if(strArray[strArray.length -1] != null){
                            try {
                                String rootDir = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "RxjavaTest";
                                File fileDir = new File(rootDir);
                                if(!fileDir.exists()){
                                    fileDir.mkdirs();
                                }
                                futureStudioIconFile = new File(rootDir + File.separator + strArray[strArray.length -1] );
                                if(futureStudioIconFile.exists()){
                                    futureStudioIconFile.delete();
                                }
                                InputStream inputStream = null;
                                OutputStream outputStream = null;

                                try {
                                    byte[] fileReader = new byte[10*1024];

                                    float fileSize = body.contentLength();
                                    float fileSizeDownloaded = 0;

                                    inputStream = body.byteStream();
                                    outputStream = new FileOutputStream(futureStudioIconFile);
                                    long currentProgress = 0;
                                    while (true) {
                                        int read = inputStream.read(fileReader);
                                        if (read == -1) {
                                            listener.onResponseProgress(100,100,false);
                                            break;
                                        }
                                        //使用了handler回调到主线程
                                        //把进度条转成100份，避免过度更新进度
                                        int progress = (int)((fileSizeDownloaded / fileSize) * 100) ;
                                        if(progress - currentProgress >= 1){
                                            listener.onResponseProgress(progress,100,false);
                                            currentProgress = progress;
                                        }
                                        outputStream.write(fileReader, 0, read);

                                        fileSizeDownloaded += read;
                                    }

                                    outputStream.flush();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                } finally {
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }

                                    if (outputStream != null) {
                                        outputStream.close();
                                    }
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        return futureStudioIconFile;
                    }
                }).subscribe(new DisposableObserver<File>() {
            @Override
            public void onNext(File file) {
                listener.onProgressFinish(file);
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onComplete() {

            }
        });
    }

    public static Message obtainMessage(int what , Object obj){
        Message msg = new Message();
        msg.what = what;
        msg.obj = obj;
        return msg;
    }
}
