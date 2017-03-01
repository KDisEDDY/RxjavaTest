package project.ljy.utils;

import android.database.sqlite.SQLiteDatabase;

/**
 * Title: OnSqliteUpdateListener
 * Description:
 * Copyright: Copyright (c) 2014-2016 gjfax.com
 * Company: 广金所
 * Author: 刘加彦
 * Date: 2017/3/1
 * Version: 1.0
 */
public interface OnSqliteUpdateListener {
    void onSqliteUpdateListener(SQLiteDatabase db, int oldVersion, int newVersion);
}
