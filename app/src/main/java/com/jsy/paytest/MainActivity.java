package com.jsy.paytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.jsy.whateverpaysdk.EntrustListener;
import com.jsy.whateverpaysdk.PayHelper;
import com.jsy.whateverpaysdk.PayListener;

public class MainActivity extends AppCompatActivity {

    TextView tvMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvMsg = findViewById(R.id.tv_msg);
        findViewById(R.id.bt_pay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testPay();
            }
        });
        findViewById(R.id.bt_entrust).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testSign();
            }
        });
    }

    private void testPay() {
        tvMsg.setText("支付中");
        PayHelper.pay(this,
                "WPc84e09f9f3f643d3a6",
                "ee0db1fc7483451a8b5b63cff43a504d",
                "hello",
                "RSA2",
                "JlT10XarpMp+D7jjZMILfIHism3aBhMh47IhZjG5cllyzpRUJHVHHEBu984qdZjey1SZZ8d3BTDgk8z1tBiJzGxiWmvNZuIu5PgESbUaZ5psGpPufYItbpmubSkxbk4Bk4G97cS3nCXTStJ4jyo/9Wbiodx6URpeEnMJ8qM411eAS2vDsdrxZ2OyYZZF4lWplA3Vu3xmG3JAnq3WhINTVhUFfAjweBjj4ZQW0ezf78gAI7TLg2iA68L1vQWI1l5Up/ROWsAqyEupxzKA1uY0PmnZCI4LWeZzU8p73sG5PnoADcHu3zrwJwy6C89SoloGiaDHVlFRF3VwYG2oZR40fuN2su/O+mhk2QNF5/lfXRly4bCk/WIIpP0K4JUXekUM13DhH1BIM0Y2U3iYKgYZNcwA4Qm0sZAnkQLwtLIO1dtnCyYDEhGKeMq0+OI0h8Rx9Y4NcY6rodcQlJ2yFhQPa3l1fOYSE/dTEP9bX/yFnjN4oUMYqF7bGTIHbk07EGhZ",
                "pay-2021031123",
                "1615515840785",
                new PayListener() {
                    @Override
                    public void onSuccess() {
                        tvMsg.setText("支付成功");
                    }

                    @Override
                    public void onFailed() {
                        tvMsg.setText("支付失败");
                    }

                    @Override
                    public void onUnAvailable() {
                        tvMsg.setText("支付应用未安装");
                    }
                });
    }

    private void testSign() {
        tvMsg.setText("签约中");
        PayHelper.entrust(this,
                "entrust-2021031114",
                "WP5f190169c8eb4139a1",
                "RSA2",
                "c9chhg1m8fxa7xCt5xH6GhKl8GREgNs/exlEGp4tzXbuztmpne5hNHQQ6QOpOCL+UXePCM+50rqe1l+8hA0QWO0PDeC6XSJt0CyTOv3VefDpO1+BFchqSxUnc/REED10Rae/c+JSUa9FThHRtWgJCe97QAW79syMFjDXH3D1CykoWDV6UTqEGNe2Rh3xhKWaS6xg8Z25mgvRL5vghb+Y505obO1YL6e+xvoZ8l6dx/2F4O9kmTN1Cz8tF0TjZGj3kxNuv14nfjs9ariZKnpOxZ0NuaYPGqD/mOuXsVlccpo2mHVhj6wv+4Vh2U5k5rF9lyaPH9Pf80QKSg+6bMT9bDU/tPW9Yf+kkBPUMfRpulEF0woZ+z3eSb7wBexcG+Ll8W7BHEtEW+ndHeAA93wHMrShvSVe5Gl2ZEpK9Cf2l5rgh/yWFum7uwFNOQr9TyPiAO9vez5MiNFTGfT0JOrvoEvQGgSej6k6g8WcZFmmWHJRhs7YV9hrrvUaHMpmaIc3",
                "ee0db1fc7483451a8b5b63cff43a504d",
                "1615456433083",
                new EntrustListener() {
                    @Override
                    public void onSuccess() {
                        tvMsg.setText("签约成功");
                    }

                    @Override
                    public void onFailed() {
                        tvMsg.setText("签约失败");
                    }

                    @Override
                    public void onUnAvailable() {
                        tvMsg.setText("支付应用未安装");
                    }
                });
    }
}
