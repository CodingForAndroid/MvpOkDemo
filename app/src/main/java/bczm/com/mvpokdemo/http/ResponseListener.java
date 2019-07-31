package bczm.com.mvpokdemo.http;

/**
 * @author zhangjun
 * @date 2019-7-19
 */
public interface ResponseListener {

    void onSuccess(String response);

    void  onFailed(Object response);
}
