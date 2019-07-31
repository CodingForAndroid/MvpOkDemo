package bczm.com.mvpokdemo.protocol;

import android.content.Context;

import java.util.Map;

/**
 * @author zhangjun
 * @date 2019-7-31
 */
public class BeautiesProtocol extends BaseProtocol {


    public BeautiesProtocol(UrlPathMaker.URL_ENUM mEnum) {
        super(mEnum);
    }

    @Override
    public METHOD getProtocolMethod() {
        METHOD m = METHOD.POST ;
        switch (getURLEnum()) {
            //福利
            case HttpUrlTypeWelfare:
                m = METHOD.GET ;
                default:
                    break;
        }
        return m ;
    }

}
