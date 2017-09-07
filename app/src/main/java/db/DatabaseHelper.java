package db;

import android.content.Context;
import java.sql.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

/**
 * Title: DatabaseHelper
 * Description:
 * Copyright: Copyright (c) 2014-2016 gjfax.com
 * Company: 广金所
 * Author: 刘加彦
 * Date: 2017/6/22
 * Version: 1.0
 */

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    // name of the database file for your application -- change to something appropriate for your app
    private static final String DATABASE_NAME = "RxjavaTest.db";
    // any time you make changes to your database objects, you may have to increase the database version
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * This is called when the database is first created. Usually you should call createTable statements here to create
     * the tables that will store your data.
     */
    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
//        try {
//            Log.i(DatabaseHelper.class.getName(), "onCreate");
//            TableUtils.createTableIfNotExists(connectionSource, TypeItemBean.class);
//        } catch (SQLException e) {
//            Log.e(DatabaseHelper.class.getName(), "Can't create database", e);
//            throw new RuntimeException(e);
//        }
    }

    /**
     * This is called when your application is upgraded and it has a higher version number. This allows you to adjust
     * the various data to match the new version number.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {
//        try {
//            Log.i(DatabaseHelper.class.getName(), "onUpgrade");
//            TableUtils.dropTable(connectionSource, TypeItemBean.class, true);
//            // after we drop the old databases, we create the new ones
//            onCreate(db, connectionSource);
//        } catch (SQLException e) {
//            Log.e(DatabaseHelper.class.getName(), "Can't drop databases", e);
//            throw new RuntimeException(e);
//        }
    }

    /**
     * Close the database connections and clear any cached DAOs.
     */
    @Override
    public void close() {
        super.close();
    }
}
