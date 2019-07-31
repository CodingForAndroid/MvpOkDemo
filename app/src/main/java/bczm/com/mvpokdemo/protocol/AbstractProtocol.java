package bczm.com.mvpokdemo.protocol;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import java.io.File;
import java.util.Map;
import bczm.com.mvpokdemo.http.HttpClient;
import bczm.com.mvpokdemo.http.ResponseListener;
import okhttp3.Call;

/**
 * @author zhangjun
 * @date 2019-7-19
 */
public abstract class AbstractProtocol {

    private static final String TAG = "AbstractProtocol";
    public AbstractProtocol(){

    }
    private HttpClient client = new HttpClient();


    ////////////////////////////////抽象方法/////////////////////////////////////

    /*** 获取请求参数 */
    public abstract Map<String,Object> getExternalBodyParams();
    /*** 获取请求参数 */
    public abstract Map<String,Object> getExternalHeaderParams();
    /** 获取请求的方法 */
    public abstract METHOD getProtocolMethod();

    /** 得到请求的url */
    public abstract String getDefaultURL();

    // ///////////////////////////////数据请求入口///////////////////////////////////

    /**
     * 网络请求方法,
     * @param responseListener response监听必须传入
     */
    public void runProtocol(ResponseListener responseListener) {
        runProtocol(null, responseListener);
    }

    /**
     * 网络请求方法,
     * @param responseListener response监听必须传入
     */
    public void runProtocol(String tag, ResponseListener responseListener) {
        runProtocol(tag, null, responseListener);
    }

    /**
     * @param tag
     * @param extParam
     *            外部活动参数 ,与getExternalParams()方法不同
     * @param responseListener response监听
     *
     */
    public void runProtocol(String tag, Bundle extParam,
                            ResponseListener responseListener) {
        runProtocol(tag, extParam, CACHEOPR.NONE,responseListener);
    }

    /**
     * @param tag
     * @param extParam
     *            外部活动参数
     * @param OPR
     *            缓存使用类型
     * @param responseListener
     */
    public void runProtocol(String tag, Bundle extParam, CACHEOPR OPR,
                            ResponseListener responseListener) {
        runProtocol(tag, extParam, null, OPR, responseListener);
    }

    /**
     *
     * @param tag
     * @param extParam
     * @param files
     * @param OPR
     * @param responseListener
     */
    public void runProtocol(String tag, Bundle extParam,
                            Map<String, File> files, CACHEOPR OPR,
                            ResponseListener responseListener) {

        //判断有没有被中断，取消 完成
        executeProtocol(client,getDefaultURL(),responseListener);
    }
    //Map<String,Object> params, ResponseLister lister
    public Call executeProtocol(HttpClient client, String URL, ResponseListener lister) {
        Call call = null;
        if (getProtocolMethod() == METHOD.GET) {

                call = client.get(URL, getExternalHeaderParams(),
                        lister);
            Log.d(TAG,
                    "get-----> " + URL );
        } else if (getProtocolMethod() == METHOD.POST) {
            call = client.post(URL,getExternalHeaderParams(), getExternalBodyParams(),
                    lister);
            Log.d(TAG,
                    "post------>" + URL );
        }
        return call;
    }



    // ///////////////////定义内部枚举类型///////////////////////////

    /** 网络请求方法 */
    public  enum METHOD {
        GET, POST
    }

    /** 返回的数据类型 */
    public  enum JSON_TYPE {
        OBJECT, ARRAY
    }

    public enum CACHEOPR {
        NONE,
        PAIR,
        PAIR_ONELISTEN_LOCAL_PRIORITY,
        PAIR_ONELISTEN_WEB_PRIORITY
    }

}
