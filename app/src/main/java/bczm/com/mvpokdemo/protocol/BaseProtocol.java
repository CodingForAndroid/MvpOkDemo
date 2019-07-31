package bczm.com.mvpokdemo.protocol;

import java.util.Map;
import bczm.com.mvpokdemo.protocol.UrlPathMaker.URL_ENUM;

/**
 * @author zhangjun
 * @date 2019-7-31
 */
public abstract class BaseProtocol extends AbstractProtocol {
    private URL_ENUM mURLEnum;
    // url param
    private String pathParam[];

    public BaseProtocol(URL_ENUM mEnum){
        mURLEnum = mEnum;
    }

    public void setPathParam(String... param) {
        this.pathParam = param;
    }
    @Override
    public Map<String, Object> getExternalBodyParams() {
        return null;
    }

    @Override
    public Map<String, Object> getExternalHeaderParams() {
        return null;
    }

    @Override
    public String getDefaultURL() {
        return UrlPathMaker.get_url(getURLEnum(), pathParam);
    }

    public URL_ENUM getURLEnum() {
        return mURLEnum;
    }

    public void setURLEnum(URL_ENUM mURLEnum) {
        this.mURLEnum = mURLEnum;
    }
}
