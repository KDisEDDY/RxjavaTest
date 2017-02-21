package utils;

import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import org.reactivestreams.Subscription;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.observers.DefaultObserver;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import project.ljy.rxjavatest.DownLoadCallBack;
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

    static Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            DownLoadCallBack callBack = (DownLoadCallBack) msg.obj;
            switch (msg.what){
                case SUCCESS:
                    callBack.onSuccess();
                    break;
                case FAILURE:
                    callBack.onFailure();
                    break;
            }
        }
    };

    public static void downloadFile(final String url , final DownLoadCallBack callBack){
        Call<ResponseBody> call =  RetrofitManager.getDownLoadApi().downLoadFile(url);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful()){
                    // TODO: 2017/2/20 实现下载到sd卡
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
                                            // todo change the file location/name according to your needs
                                            File futureStudioIconFile = new File(rootDir + File.separator + strArray[strArray.length -1] );
                                            if(futureStudioIconFile.exists()){
                                                futureStudioIconFile.delete();
                                            }
                                            InputStream inputStream = null;
                                            OutputStream outputStream = null;

                                            try {
                                                byte[] fileReader = new byte[4096];

                                                long fileSize = body.contentLength();
                                                long fileSizeDownloaded = 0;

                                                inputStream = body.byteStream();
                                                outputStream = new FileOutputStream(futureStudioIconFile);

                                                while (true) {
                                                    int read = inputStream.read(fileReader);

                                                    if (read == -1) {
                                                        break;
                                                    }

                                                    outputStream.write(fileReader, 0, read);

                                                    fileSizeDownloaded += read;

                                                    Log.d("DOWNLOAD", "file download: " + fileSizeDownloaded + " of " + fileSize);
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

    public static Message obtainMessage(int what , Object obj){
        Message msg = new Message();
        msg.what = what;
        msg.obj = obj;
        return msg;
    }
}
