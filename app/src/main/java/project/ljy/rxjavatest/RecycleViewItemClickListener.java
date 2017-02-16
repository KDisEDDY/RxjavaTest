package project.ljy.rxjavatest;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Title: RecycleViewItemClickListener
 * Description:
 * Copyright: Copyright (c) 2014-2016 gjfax.com
 * Company: 广金所
 * Author: 刘加彦
 * Date: 2017/2/16
 * Version: 1.0
 */
public interface RecycleViewItemClickListener {
    interface ItemClickListener{
        void onItemClickListener(View v , int position);
    }

    interface LongItemClickListener{
        void onLongItemClickListener(View v, int position);
    }
}
