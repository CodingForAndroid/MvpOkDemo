package bczm.com.mvpokdemo.ui.tablayout;


import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * @author zhangjun
 * @date 2019-8-1
 */
public class MyFragment extends Fragment {


    private String arg1,arg2;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

         arg1 = (String) getArguments().get("arg1");
         arg2 = (String) getArguments().get("arg2");

        Log.e("MyFragment","onCreate");
    }
    @Override
    public void onStart() {
        super.onStart();
        Log.e("MyFragment","onStart");
    }
    @Override
    public void onResume() {
        super.onResume();
        Log.e("MyFragment","onResume");
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e("MyFragment","onSaveInstanceState");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e("MyFragment","onPause");
    }
    @Override
    public void onStop() {
        super.onStop();
        Log.e("MyFragment","onStop");
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("MyFragment","onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e("MyFragment","onDetach");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e("MyFragment","onDestroyView");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Log.e("MyFragment","onCreateView");
        TextView textView = new TextView(getContext());
        textView.setText(arg1);
        return textView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.e("MyFragment","onActivityCreated");
        super.onActivityCreated(savedInstanceState);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Log.e("MyFragment","onViewCreated");
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        Log.e("MyFragment","onHiddenChanged");
        super.onHiddenChanged(hidden);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Log.e("MyFragment","onConfigurationChanged");
        super.onConfigurationChanged(newConfig);
    }



    public static MyFragment newInstance(String arg1,String arg2) {

        Bundle args = new Bundle();
        args.putString("arg1",arg1);
        args.putString("arg2",arg2);
        MyFragment fragment = new MyFragment();
        fragment.setArguments(args);
        return fragment;
    }




}
