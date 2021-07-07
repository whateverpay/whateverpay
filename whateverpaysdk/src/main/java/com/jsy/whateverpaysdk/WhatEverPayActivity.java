package com.jsy.whateverpaysdk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

public class WhatEverPayActivity extends Activity {

    private static PayListener payListener;
    private static EntrustListener entrustListener;
    private static EntrustAndPayListener entrustAndPayListener;

    public static void setPayListener(PayListener payListener) {
        WhatEverPayActivity.entrustListener = null;
        WhatEverPayActivity.entrustAndPayListener = null;
        WhatEverPayActivity.payListener = payListener;
    }

    public static void setEntrustListener(EntrustListener entrustListener){
        WhatEverPayActivity.payListener = null;
        WhatEverPayActivity.entrustAndPayListener = null;
        WhatEverPayActivity.entrustListener = entrustListener;
    }

    public static void setEntrustAndPayListener(EntrustAndPayListener entrustAndPayListener){
        WhatEverPayActivity.payListener = null;
        WhatEverPayActivity.entrustListener = null;
        WhatEverPayActivity.entrustAndPayListener = entrustAndPayListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent()
                .setComponent(null)
                .setAction("com.jsy.whateverpay.pay");
        startActivityForResult(intent, 1);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        finish();
        if (resultCode == RESULT_OK) {
            if (payListener != null) {
                payListener.onSuccess();
            }else if (entrustListener != null) {
                entrustListener.onSuccess();
            }else if (entrustAndPayListener != null) {
                entrustAndPayListener.onSuccess();
            }
        } else {
            if (payListener != null) {
                payListener.onFailed();
            }else if (entrustListener != null) {
                entrustListener.onFailed();
            }else if (entrustAndPayListener != null) {
                entrustAndPayListener.onFailed();
            }
        }
    }
}
