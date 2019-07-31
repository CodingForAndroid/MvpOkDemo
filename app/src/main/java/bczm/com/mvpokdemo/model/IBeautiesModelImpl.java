package bczm.com.mvpokdemo.model;

import android.util.Log;

import bczm.com.mvpokdemo.http.ResponseJsonListener;
import bczm.com.mvpokdemo.protocol.BeautiesProtocol;
import bczm.com.mvpokdemo.protocol.UrlPathMaker.URL_ENUM;

/**
 * @author zhangjun
 * @date 2019-7-30
 */
public class IBeautiesModelImpl implements IBeautiesModel {
    @Override
    public void loadBeauties(BeautiesOnLoadListener beautiesOnLoadListener,int index) {

        BeautiesProtocol protocol = new BeautiesProtocol(URL_ENUM.HttpUrlTypeWelfare);
        protocol.setPathParam("10",""+index);
        protocol.runProtocol(new ResponseJsonListener<Beauties>() {
            @Override
            public void onSuccess(Beauties beauties) {
                for(Beauties.ResultsBean bean:beauties.getResults()){
                    Log.e("onResponse",""+bean.getUrl());
                }
                beautiesOnLoadListener.onComplete(beauties);
            }
        });
    }
}
