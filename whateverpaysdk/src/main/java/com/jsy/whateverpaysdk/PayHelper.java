package com.jsy.whateverpaysdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import java.util.List;

/**
 * Created by Dell on 2020/10/10.
 */

public class PayHelper {

    public static void pay(Context context,String appid,String mchId,String nonceStr,String signType,String sign,String prepayId,String timestamp,PayListener payListener) {
        if (!isWhatEverPayAvailable(context)){
            payListener.onUnAvailable();
            return;
        }
        Intent intent = new Intent(context,WhatEverPayActivity.class);
        intent.putExtra("type","pay")
                .putExtra("appid",appid)
                .putExtra("mch_id",mchId)
                .putExtra("nonce_str",nonceStr)
                .putExtra("sign_type",signType)
                .putExtra("sign",sign)
                .putExtra("prepayid",prepayId)
                .putExtra("timestamp",timestamp);
        WhatEverPayActivity.setPayListener(payListener);
        context.startActivity(intent);
    }


    public static void entrust(Context context,String contract_id,String appid,String signType,String sign,String mch_id,String timestamp,EntrustListener entrustListener){
        if (!isWhatEverPayAvailable(context)){
            entrustListener.onUnAvailable();
            return;
        }
        Intent intent = new Intent(context,WhatEverPayActivity.class);
        intent.putExtra("type","entrust")
                .putExtra("contract_id",contract_id)
                .putExtra("appid",appid)
                .putExtra("sign_type",signType)
                .putExtra("sign",sign)
                .putExtra("mch_id",mch_id)
                .putExtra("timestamp",timestamp);

        WhatEverPayActivity.setEntrustListener(entrustListener);
        context.startActivity(intent);
    }

    public static void entrustAndPay(Context context,String fee_type, String nonce_str,String contract_id,String appid,String signType,String sign,String mch_id,String timestamp,
                                     String out_trade_no, String total_fee, String attach,
                                     String spbill_create_ip, String pay_notify_url,String body,
                                     EntrustAndPayListener entrustAndPayListener){
        if (!isWhatEverPayAvailable(context)){
            entrustAndPayListener.onUnAvailable();
            return;
        }
        Intent intent = new Intent(context,WhatEverPayActivity.class);
        intent.putExtra("type","entrust")
                .putExtra("fee_type",fee_type)
                .putExtra("nonce_str",nonce_str)
                .putExtra("contract_id",contract_id)
                .putExtra("appid",appid)
                .putExtra("sign_type",signType)
                .putExtra("sign",sign)
                .putExtra("mch_id",mch_id)
                .putExtra("timestamp",timestamp)
                .putExtra("out_trade_no",out_trade_no)
                .putExtra("total_fee",total_fee)
                .putExtra("attach",attach)
                .putExtra("spbill_create_ip",spbill_create_ip)
                .putExtra("pay_notify_url",pay_notify_url)
                .putExtra("body",body);

        WhatEverPayActivity.setEntrustAndPayListener(entrustAndPayListener);
        context.startActivity(intent);
    }

    /**
     * 检测是否安装了WhatEverPay
     * @param context
     * @return
     */
    private static boolean isWhatEverPayAvailable(Context context) {
        final PackageManager packageManager = context.getPackageManager();
        List<PackageInfo> pi = packageManager.getInstalledPackages(0);
        if (pi != null) {
            for (int i = 0; i < pi.size(); i++) {
                String pn = pi.get(i).packageName;
                if (pn.equals("com.jsy.whateverpay")) {
                    return true;
                }
            }
        }
        return false;
    }

}
