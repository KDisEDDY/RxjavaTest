package project.ljy.rxjavatest;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends BaseActivity
        implements BaseActivity.OnNavigationItemSelectedListener, BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView mBnvNavigation;
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
        } else if (id == R.id.item_calendar) {
            setWindowTitle(item.getTitle().toString());
        } else if (id == R.id.item_finish_record) {
            setWindowTitle(item.getTitle().toString());
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
}
