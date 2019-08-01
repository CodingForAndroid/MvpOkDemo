package bczm.com.mvpokdemo.base;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;

/**
 * @author zj on 2017-7-19.
 */



public abstract class BaseFragment extends Fragment {



	/* add new end */
    private Handler mDefaultHandler = new MyHandler(this);

    /** 内置handler */
    private static class MyHandler extends Handler {
        private final WeakReference<BaseFragment> mWeakAct;

        public MyHandler(BaseFragment fragment) {
            mWeakAct = new WeakReference<BaseFragment>(fragment);
        }

        @Override
        public void handleMessage(android.os.Message msg) {
            final BaseFragment fragment = mWeakAct.get();
            if (fragment == null||fragment.isDetached()) {
                return;
            }
            fragment.onHandleMessage(msg);
        }
    }
    /**
     * 内置handler处理到某个消息时，该方法被回调。子类实现该方法以定义对消息的处理。
     *
     * @param msg
     *            消息
     */
    protected abstract void onHandleMessage(Message msg);

    /**
     * 获取内置handler
     *
     * @return 内置handler
     */
    public Handler getDefaultHandler() {
        return mDefaultHandler;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState!=null && getArguments()!=null) {
            getArguments().putAll(savedInstanceState) ;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return createView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        findViews() ;
        initData() ;
        setListener() ;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        free() ;
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        if (getArguments()!=null) {
            outState.putAll(getArguments()) ;
        }
        super.onSaveInstanceState(outState);
    }

    /***
     * set layout
     */
    protected abstract View createView(LayoutInflater inflater, ViewGroup container,
                                          Bundle savedInstanceState);
    /***
     * find views
     */
    protected abstract void findViews();
    /***
     * initial data
     */
    protected abstract void initData();
    /***
     * set views listener
     */
    protected abstract void setListener();
    /**
     * free useless resource
     */
    public abstract void free();


}
