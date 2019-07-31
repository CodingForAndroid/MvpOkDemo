package bczm.com.mvpokdemo.presenter;

import bczm.com.mvpokdemo.model.IBeautiesModel;
import bczm.com.mvpokdemo.model.IBeautiesModelImpl;
import bczm.com.mvpokdemo.view.IBeautiesView;


/**
 * @author zhangjun
 * @date 2019-7-30
 */
public class BeautiesPresenter<T extends IBeautiesView> extends BasePresenter<T> {
    private int index = 1;
    //2.需要Model的引用
    IBeautiesModel iBeautiesModel = new IBeautiesModelImpl();

    //3.需要执行UI逻辑

    public void fetch(){
        if(iBaseView.get()!=null&&iBeautiesModel!=null){
            //回调数据,处理UI
            index = 1;
            iBeautiesModel.loadBeauties((beauties)->
                    iBaseView.get().showBeauties(beauties)
            ,index);
        }
    }

    public void loadMore() {
        if(iBaseView.get()!=null&&iBeautiesModel!=null){
            //回调数据,处理UI
            iBeautiesModel.loadBeauties((beauties)->
                    iBaseView.get().showBeauties(beauties)
            ,++index);
        }
    }
}
