package com.jsy.whateverpaysdk;

/**
 * Created by Dell on 2020/10/16.
 */

public interface EntrustAndPayListener {

    //签约并支付成功
    void onSuccess();

    //签约并支付失败
    void onFailed();

    //应用未安装
    void onUnAvailable();
}
