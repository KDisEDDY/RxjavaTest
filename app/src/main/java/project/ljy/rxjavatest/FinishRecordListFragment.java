package project.ljy.rxjavatest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by EDDY on 2017/9/24.
 */

public class FinishRecordListFragment extends Fragment {
    public FinishRecordListFragment(){

    }
    public static FinishRecordListFragment newInstance(Bundle bundle) {
        FinishRecordListFragment fragment = new FinishRecordListFragment();
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
        return inflater.inflate(R.layout.fragment_finish_record_list,container,false);
    }
}
