package bczm.com.mvpokdemo.view;

import bczm.com.mvpokdemo.model.Beauties;

/**
 * @author zhangjun
 * @date 2019-7-30
 */
public interface IBeautiesView {
    /**
     * 显示美女图片
     * @param beauties
     */
    void showBeauties(Beauties beauties);
    /**
     * 其他UI逻辑....
     */
}
