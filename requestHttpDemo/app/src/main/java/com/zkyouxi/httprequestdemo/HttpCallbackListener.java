package com.zkyouxi.httprequestdemo;

public interface HttpCallbackListener {
    void onFinish(String response);
    void onError(Exception e);
}
