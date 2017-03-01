package project.ljy.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import java.io.File;

/**
 * Title: CommonUtils
 * Description: 比较基本的工具方法
 * Copyright: Copyright (c) 2014-2016 gjfax.com
 * Company: 广金所
 * Author: 刘加彦
 * Date: 2017/3/1
 * Version: 1.0
 */
public class CommonUtils {
    public static void installAPK(Context context , File file){
        Intent intent = new Intent(Intent.ACTION_VIEW);

        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        intent.setAction(Intent.ACTION_VIEW);

        intent.setDataAndType(Uri.fromFile(file),

                "application/vnd.android.package-archive");

        context.startActivity(intent);
    }
}
