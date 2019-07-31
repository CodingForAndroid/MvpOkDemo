package bczm.com.mvpokdemo.http;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author zhangjun
 * @date 2019-7-22
 */
public abstract class ResponseJsonListener<Result> implements ResponseListener {


    @Override
    public void onFailed(Object response) {

    }

    @Override
    public void onSuccess(String response) {
        Gson gson = new Gson();
        Type type =getClass().getGenericSuperclass();
        Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
        Type argument = actualTypeArguments[0];
        Result result = gson.fromJson(response, argument);
        onSuccess(result);
    }


    public abstract void  onSuccess(Result result);
}
