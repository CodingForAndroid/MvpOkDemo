package bczm.com.mvpokdemo.http;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * @author zhangjun
 * @date 2019-7-19
 */
public class HttpClient {
    private OkHttpClient mOkHttpClient;
    private static final long DEFAULT_MILLISECONDS = 60000;      //默认的超时时间
    private Handler handler;

    public HttpClient(){


        if(mOkHttpClient==null){

            OkHttpClient.Builder builder = new OkHttpClient.Builder();

            builder.readTimeout(DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);
            builder.writeTimeout(DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);
            builder.connectTimeout(DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);
            builder.sslSocketFactory(createSSLSocketFactory());
            builder.hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
            mOkHttpClient = builder.build();

        }

        if(handler==null){
            if (Looper.myLooper() == Looper.getMainLooper()){
                handler = new Handler();
            }else {
                handler = new Handler(Looper.getMainLooper());
            }
        }

    }


    private static SSLSocketFactory createSSLSocketFactory() {
        SSLSocketFactory ssfFactory = null;

        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, new TrustManager[]{new TrustAllCerts()}, new SecureRandom());

            ssfFactory = sc.getSocketFactory();
        } catch (Exception e) {
        }

        return ssfFactory;
    }


    public Call get(String url, Map<String,Object> headerParams, ResponseListener lister){
        Request request = appendHeaders(headerParams)
                .url(url)
                .build();

        //拦截器 添加 header info
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                handler.post(()-> lister.onFailed(e.toString()));
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response.isSuccessful()){
                    String string = response.body().string();
                    handler.post(() -> {
                            lister.onSuccess(string);
                    });
                }else {
                    handler.post(()-> lister.onFailed(response.message()));
                }
            }
        });
        return call ;
    }

    public Call post(String url, Map<String,Object> headerParams, Map<String,Object> bodyParams, ResponseListener lister){
        Request request = appendHeaders(headerParams)
                .url(url)
                .post(appendBody(bodyParams))
                .build();
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

                handler.post(()-> lister.onFailed(e.toString()));
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response.isSuccessful()){
                    String string = response.body().string();
                    handler.post(() -> { lister.onSuccess(string);});
                }else {
                    handler.post(()-> lister.onFailed(response.message()));

                }
            }
        });
        return call ;
    }

    private RequestBody appendBody(Map<String,Object> params){
        FormBody.Builder builder = new FormBody.Builder();
        if(params == null || params.isEmpty()){
            return builder.build();
        }
        for (Map.Entry<String,Object> entry:params.entrySet()) {
            builder.add(entry.getKey(),entry.getValue().toString());
        }
        return builder.build();
    }

    private  Request.Builder appendHeaders(Map<String,Object> params){
        Request.Builder builder = new Request.Builder();
        if(params == null || params.isEmpty()){
            return builder;
        }
        for (Map.Entry<String,Object> entry:params.entrySet()) {
            builder.addHeader(entry.getKey(),entry.getValue().toString());
        }
        return builder;
    }
}
