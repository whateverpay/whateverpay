package com.jsy.whateverpaysdk;

/**
 * Created by Dell on 2020/10/10.
 */

public interface PayListener {

    //支付成功
    void onSuccess();

    //支付失败
    void onFailed();

    //应用未安装
    void onUnAvailable();
}
