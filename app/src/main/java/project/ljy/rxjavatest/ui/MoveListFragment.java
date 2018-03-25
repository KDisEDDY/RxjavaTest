package project.ljy.rxjavatest.ui;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import project.ljy.rxjavatest.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MoveListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MoveListFragment extends Fragment {
    //相当于intent传送的标志变量
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private Action mAction;
    public MoveListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment MoveListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MoveListFragment newInstance(Bundle bundle) {
        MoveListFragment fragment = new MoveListFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            getArguments().getString(ARG_PARAM1);
            getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //测试用接口做Activity和Fragment的通信
        mAction = (Action) context;
        mAction.sendData("Bird MAN");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       return inflater.inflate(R.layout.fragment_record_list,container,false);
    }

    public interface Action {
        void sendData(String str);
    }
}
