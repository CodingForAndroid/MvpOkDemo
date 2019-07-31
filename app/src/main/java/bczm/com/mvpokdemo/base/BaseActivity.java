package bczm.com.mvpokdemo.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import java.util.List;

import bczm.com.mvpokdemo.presenter.BasePresenter;

/**
 * @author zhangjun
 * @date 2019-6-5
 */
public abstract class BaseActivity<V,T extends BasePresenter<V>> extends Activity {
    public T presenter;
    public List<T> presenters;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //创建表示层
        presenter = createPresenter();

        presenters = createPresenters();
        //绑定View
        presenter.attachView((V)this);

        if(presenters!=null){
            for (T p:presenters){
                p.attachView((V)this);
            }
        }

    }

    /**
     * 创建表示层 业务逻辑多的话，可以创建多个表示层，可以返回一个 List<P>
     * @return presenter
     */
    protected abstract T createPresenter();
    /**
     * 创建表示层 Presenters
     * @return presenter
     */
    protected abstract List<T> createPresenters();
    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();

        if(presenters!=null){
            for (T p:presenters){
                p.detachView();
            }
        }
    }

}
