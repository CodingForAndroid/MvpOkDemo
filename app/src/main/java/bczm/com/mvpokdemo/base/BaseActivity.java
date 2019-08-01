package bczm.com.mvpokdemo.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import bczm.com.mvpokdemo.presenter.BasePresenter;

/**
 * @author zhangjun
 * @date 2019-6-5
 */
public abstract class BaseActivity<V, T extends BasePresenter<V>> extends AppCompatActivity {
    public T presenter;
    public List<T> presenters;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //创建表示层
        presenter = createPresenter();

        presenters = createPresenters();
        //绑定View
        if(presenter!=null){
            presenter.attachView((V) this);
        }

        if (presenters != null) {
            for (T p : presenters) {
                p.attachView((V) this);
            }
        }
        setContentView(getLayoutId());
        findViews();
        initData();
        setListener();
    }

    /**
     * ui
     *
     * @return R.layout.xx
     */
    protected abstract int getLayoutId();

    /**
     * 创建表示层 业务逻辑多的话，可以创建多个表示层，可以返回一个 List<P>
     *
     * @return presenter
     */
    protected abstract T createPresenter();

    /**
     * 创建表示层 Presenters
     *
     * @return presenter
     */
    protected abstract List<T> createPresenters();

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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();

        if (presenters != null) {
            for (T p : presenters) {
                p.detachView();
            }
        }
    }

}
