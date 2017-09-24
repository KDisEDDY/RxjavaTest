package db;

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

    public static final String CREATE_TABLE_RECORDLIST = "create table record ("
            + "id integer primary key autoincrement, "
            + "title VARCHAR NOT NULL, "
            + "time VARCHAR, "
            + "level INTEGER, "
            + "lockTime VARCHAR, "
            + "content VARCHAR, "
            + "isFinish INTEGER)";

    /**登录个人信息*/
    public static final String CREATE_TABLE_USER =  "create table user ("
            + "id integer primary key autoincrement, "
            + "userid VARCHAR NOT NULL, "
            + "username VARCHAR NOT NULL, "
            + "phone VARCHAR, "
            + "password VARCHAR, "
            + "token VARCHAR)";

    public static final String DBNAME = "LazyKiller.db";

    public static final String TABLE_USER = "user";
    public static final String TABLE_RECORDLIST = "record";

    public static final int VERSION = 1;
}
