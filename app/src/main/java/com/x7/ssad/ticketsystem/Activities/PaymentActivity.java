package com.x7.ssad.ticketsystem.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.x7.ssad.ticketsystem.R;

import java.util.ArrayList;
import java.util.HashMap;

import io.github.mayubao.pay_library.AliPayAPI;
import io.github.mayubao.pay_library.AliPayReq2;
import io.github.mayubao.pay_library.PayAPI;
import io.github.mayubao.pay_library.WechatPayReq;

/**
 * Created by huaxiao on 2017/5/29.
 */

public class PaymentActivity extends AppCompatActivity{

    String[] from={"left","right"};                                  //这里是ListView显示内容每一列的列名
    int[] to={R.id.payment_item_left,R.id.payment_item_right};      //这里是ListView显示每一列对应的list_item中控件的id
    String[] payment_item_left = {"折扣卡", "优惠券", "礼品卡"};
    String[] payment_item_right = {"无可用", "无可用", "无可用"};
    ArrayList<HashMap<String, String>> list = null;
    HashMap<String, String> map = null;

    private ListView listview = null;
    private Button pay_btn = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment);

        listview = (ListView) findViewById(R.id.payment_list);
        list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            map = new HashMap<>();
            map.put("left", payment_item_left[i]);
            map.put("right", payment_item_right[i]);
            list.add(map);
        }

        SimpleAdapter adapter = new SimpleAdapter(this, list, R.layout.payment_list_item, from, to);
        listview.setAdapter(adapter);

//        pay_btn = (Button) findViewById(R.id.PaymentBtn);
//        pay_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //1.创建微信支付请求
//                WechatPayReq wechatPayReq = new WechatPayReq.Builder()
//                        .with(PaymentActivity.this) //activity实例
//                        .setAppId("1") //微信支付AppID
//                        .setPartnerId("1")//微信支付商户号
//                        .setPrepayId("1")//预支付码
////								.setPackageValue(wechatPayReq.get)//"Sign=WXPay"
//                        .setNonceStr("1")
//                        .setTimeStamp("1")//时间戳
//                        .setSign("1")//签名
//                        .create();
//                //2.发送微信支付请求
//                PayAPI.getInstance().sendPayRequest(wechatPayReq);
//            }
//        });
    }
}
