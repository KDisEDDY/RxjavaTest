package project.ljy.rxjavatest;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import utils.StatusBarUtil;

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
    private OnNavigationItemSelectedListener mNavigationSelectedListener ;

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

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /**
     * 初始化title
     * @param title
     * @param toolbarStyle
     */
    public void initTitle(String title,int toolbarStyle){
        setWindowTitle(title);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if(toolbarStyle == BaseConstant.STYLE_DRAWERLAYOUT){
            StatusBarUtil.setColorForDrawerLayout(this,drawer,getResources().getColor(R.color.colorPrimary));
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.addDrawerListener(toggle);
            toggle.syncState();

            final NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    return mNavigationSelectedListener != null && mNavigationSelectedListener.onNavigationItemSelected(item);
                }
            });
        } else if(toolbarStyle == BaseConstant.STYLE_RETURN_BACK){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            if(drawer != null){
                drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
            }
            StatusBarUtil.setColor(this, getResources().getColor(R.color.colorPrimary));
        }
    }

    public void setWindowTitle(String title){
        TextView titleTxt = (TextView) findViewById(R.id.tv_title);
        titleTxt.setText(title);
    }

    public void setWindowTitle(int titleId){
        if(titleId != 0){
            TextView titleTxt = (TextView) findViewById(R.id.tv_title);
            titleTxt.setText(titleId);
        }
    }

    public void addNavigationItemSelectedListener(OnNavigationItemSelectedListener onNavigationItemSelectedListener){
        mNavigationSelectedListener = onNavigationItemSelectedListener;
    }

    /**
     * the same as the {@link android.support.design.widget.BottomNavigationView.OnNavigationItemSelectedListener}
     * */
    public interface OnNavigationItemSelectedListener {
        boolean onNavigationItemSelected(@NonNull MenuItem item);
    }
}
