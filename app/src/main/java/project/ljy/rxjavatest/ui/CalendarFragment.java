package project.ljy.rxjavatest.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import project.ljy.rxjavatest.R;

/**
 * Created by EDDY on 2017/9/24.
 */

public class CalendarFragment extends Fragment {

    public CalendarFragment(){

    }
    public static CalendarFragment newInstance(Bundle bundle) {
        CalendarFragment fragment = new CalendarFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_calendar , container,false);
    }
}
