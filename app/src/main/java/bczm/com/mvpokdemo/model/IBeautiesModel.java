package bczm.com.mvpokdemo.model;

import java.util.List;

/**
 * @author zhangjun
 * @date 2019-7-30
 */
public interface IBeautiesModel {
    /**
     * 获取数据
     */
    void loadBeauties(BeautiesOnLoadListener beautiesOnLoadListener,int index);

    interface BeautiesOnLoadListener{
        void onComplete( Beauties beauties);
    }
}
