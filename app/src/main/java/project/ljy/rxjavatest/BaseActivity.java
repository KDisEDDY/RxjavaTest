package project.ljy.rxjavatest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

/**
 * Title: BaseActivity
 * Description:封装BaseActivity
 * Copyright: Copyright (c) 2014-2016 gjfax.com
 * Company: 广金所
 * Author: 刘加彦
 * Date: 2017/9/5
 * Version: 1.0
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected Toolbar mToolbar ;

    public abstract int setSubContentView();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(setSubContentView() != 0){
            setContentView(setSubContentView());
        }
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if(mToolbar != null){
            setSupportActionBar(mToolbar);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }


    }

    public void initTitle(String title,int toolbarStyle){
        TextView titleTxt = (TextView) findViewById(R.id.tv_title);
        titleTxt.setText(title);
        if(toolbarStyle == BaseConstant.STYLE_DRAWERLAYOUT){
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.addDrawerListener(toggle);
            toggle.syncState();
        } else if(toolbarStyle == BaseConstant.STYLE_RETURN_BACK){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
}
