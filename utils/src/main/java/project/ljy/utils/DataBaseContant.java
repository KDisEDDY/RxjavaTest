package project.ljy.utils;

/**
 * Title: DataBaseContant
 * Description:
 * Copyright: Copyright (c) 2014-2016 gjfax.com
 * Company: 广金所
 * Author: 刘加彦
 * Date: 2017/9/14
 * Version: 1.0
 */

public class DataBaseContant {

    public static final String CREATETABLESQL = "create table Book ("
            + "id integer primary key autoincrement, "
            + "title VARCHAR NOT NULL, "
            + "time VARCHAR, "
            + "level INTEGER, "
            + "lockTime VARCHAR"
            + "content VARCHAR"
            + "isFinish INTEGER)";
    public static final String DBNAME = "LazyKiller.db";

    public static final int VERSION = 1;
}
