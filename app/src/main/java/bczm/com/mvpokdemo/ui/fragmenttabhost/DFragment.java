package bczm.com.mvpokdemo.ui.fragmenttabhost;

import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import bczm.com.mvpokdemo.base.BaseFragment;

/**
 * @author zhangjun
 * @date 2019-8-1
 */
public class DFragment extends BaseFragment {
    @Override
    protected void onHandleMessage(Message msg) {

    }

    @Override
    protected View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.e("MyFragment","DFragment");
        TextView textView = new TextView(getContext());
        textView.setText("DFragment");
        return textView;
    }

    @Override
    protected void findViews() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setListener() {

    }

    @Override
    public void free() {

    }
}
