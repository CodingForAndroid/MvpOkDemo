package bczm.com.mvpokdemo.presenter;

import java.lang.ref.WeakReference;

/**
 * 表示层 的职责
 *1.需要View的引用
 *2.需要Model的引用
 *3.需要执行UI逻辑
 * @author zhangjun
 * @date 2019-6-5
 */
public class BasePresenter<T> {


    //1.需要View的引用
    WeakReference<T> iBaseView;

    //绑定View
    public void attachView(T view){
        iBaseView = new WeakReference<T>(view);
    }

    public void detachView(){
        iBaseView.clear();
    }

}
