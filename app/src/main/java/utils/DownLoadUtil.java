package utils;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.observers.DefaultObserver;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import project.ljy.rxjavatest.DownLoadCallBack;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Title: DownLoadUtil
 * Description:
 * Copyright: Copyright (c) 2014-2016 gjfax.com
 * Company: 广金所
 * Author: 刘加彦
 * Date: 2017/2/20
 * Version: 1.0
 */
public class DownLoadUtil {

    public static void downloadFile(String url , final DownLoadCallBack callBack){
        Call<ResponseBody> call =  RetrofitManager.getDownLoadApi().downLoadFile(url);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful()){
                    //// TODO: 2017/2/20 实现下载到sd卡
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                callBack.onFailure();
            }
        });
    }

    private boolean writeResponseBodyToDisk(ResponseBody body , String fileName) {
        try {
            String rootDir = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "RxjavaTest";
            // todo change the file location/name according to your needs
            File futureStudioIconFile = new File(rootDir + File.separator + fileName );

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

                return true;
            } catch (IOException e) {
                return false;
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }

                if (outputStream != null) {
                    outputStream.close();
                }
            }
        } catch (IOException e) {
            return false;
        }
    }
}