package project.ljy.rxjavatest.network;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;
import okhttp3.ResponseBody;
import project.ljy.rxjavatest.data.BaseBO;

/**
 * Title: Callable
 * Description:
 * Copyright: Copyright (c) 2014-2016 gjfax.com
 * Company: 广金所
 * Author: 刘加彦
 * Date: 2018/3/31
 * Version: 1.0
 */

public abstract class Callable<T extends BaseBO> {

    private Class<T> rspClass;

    public Callable(Class<T> rspClass) {
        this.rspClass = rspClass;
    }

    public Class<T> getRspClass() {
        return rspClass;
    }

    abstract void onFailure(Call call, IOException e);

    abstract void onResponse(Call call, T data) throws IOException;
}
