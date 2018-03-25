package project.ljy.rxjavatest.base;

import android.app.Application;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import db.DataBaseContant;
import project.ljy.utils.DataBaseOpenHelper;
import project.ljy.utils.OnSqliteUpdateListener;

/**
 * Title: BaseApplication
 * Description: application类
 * Copyright: Copyright (c) 2014-2016 gjfax.com
 * Company: 广金所
 * Author: 刘加彦
 * Date: 2017/9/14
 * Version: 1.0
 */

public class BaseApplication extends Application {

    SQLiteDatabase mSqlite;
    public static DataBaseOpenHelper mDataBaseHelper ;
    @Override
    public void onCreate() {
        super.onCreate();

        initDataBase();
    }

    /** 初始化数据库 */
    private void initDataBase(){
        if(mSqlite == null){
            List<String> tableList = new ArrayList<>();
            tableList.add(DataBaseContant.CREATE_TABLE_RECORDLIST);
            tableList.add(DataBaseContant.CREATE_TABLE_USER);
            mDataBaseHelper = DataBaseOpenHelper.getInstance(this,DataBaseContant.DBNAME,DataBaseContant.VERSION,tableList);
            mSqlite = mDataBaseHelper.getWritableDatabase();
            mDataBaseHelper.setOnSqliteUpdateListener(new OnSqliteUpdateListener() {
                @Override
                public void onSqliteUpdateListener(SQLiteDatabase db, int oldVersion, int newVersion) {

                }
            });
        }
    }
}
