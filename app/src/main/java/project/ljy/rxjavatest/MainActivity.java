package project.ljy.rxjavatest;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import event.CommonEvent;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import utils.RxBus;

public class MainActivity extends BaseActivity
        implements BaseActivity.OnNavigationItemSelectedListener, BottomNavigationView.OnNavigationItemSelectedListener {

    private static final int TAB_RECORD_LIST = 0;
    private static final int TAB_CALENDAR = 1;
    private static final int TAB_FINISH_RECORD_LIST = 2;

    private BottomNavigationView mBnvNavigation;

    private FragmentManager mManager ;

    private RelativeLayout mContainLayout;
    private Fragment[] mTabFragments ;
    @Override
    public int setSubContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initTitle("列表", BaseConstant.STYLE_DRAWERLAYOUT);
        addNavigationItemSelectedListener(this);

        initView();
        initFragment();
        registerRxbus();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            Toast.makeText(this, "nav_gallery", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        } else if (id == R.id.item_record_list) {
            setWindowTitle(item.getTitle().toString());
            showFragment(TAB_RECORD_LIST);
        } else if (id == R.id.item_calendar) {
            setWindowTitle(item.getTitle().toString());
            showFragment(TAB_CALENDAR);
        } else if (id == R.id.item_finish_record) {
            setWindowTitle(item.getTitle().toString());
            showFragment(TAB_FINISH_RECORD_LIST);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void initView() {
        mBnvNavigation = (BottomNavigationView) findViewById(R.id.bnv_navigation);
        mBnvNavigation.setOnNavigationItemSelectedListener(this);
        mContainLayout = (RelativeLayout) findViewById(R.id.frag_container);
        mTabFragments = new Fragment[mBnvNavigation.getMenu().size()];
    }

    private void initFragment(){
        mManager = getSupportFragmentManager();
        FragmentTransaction transaction = mManager.beginTransaction();
        mTabFragments = new Fragment[3];
        RecordListFragment listFragment = RecordListFragment.newInstance(new Bundle());
        mTabFragments[TAB_RECORD_LIST] = listFragment;
        transaction.add(R.id.frag_container,listFragment);
        CalendarFragment calendarFragment = CalendarFragment.newInstance(new Bundle());
        mTabFragments[TAB_CALENDAR] = calendarFragment;
        transaction.add(R.id.frag_container,calendarFragment);
        FinishRecordListFragment finishRecordListFragment = FinishRecordListFragment.newInstance(new Bundle());
        mTabFragments[TAB_FINISH_RECORD_LIST] = finishRecordListFragment;
        transaction.add(R.id.frag_container,finishRecordListFragment);
        transaction.commitAllowingStateLoss();
        showFragment(TAB_RECORD_LIST);
    }

    private void showFragment(int index){
        FragmentTransaction transaction = mManager.beginTransaction();
        for(int i = 0 ; i < mTabFragments.length ; i++){
            if(i == index){
                transaction.show(mTabFragments[i]);
            } else {
                transaction.hide(mTabFragments[i]);
            }
        }
        transaction.commit();
    }

    private void registerRxbus(){
        RxBus.getDefault().toObservable(CommonEvent.class).subscribe(new Consumer<CommonEvent>() {
            @Override
            public void accept(CommonEvent commonEvent) throws Exception {
                if(commonEvent == CommonEvent.UPDATE_LIST){

                }
            }
        });
    }
}
