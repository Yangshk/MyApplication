package com.example.xuxue;


import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

/*
BroadcastReceiver 向 Activity 传值
//MainActivity实现了setBatteryText接口
在Activity中调用BatteryChange中的
getBatteryText(setBatteryText setBattery)方法
把当前对象传到BatteryChange中
setBatteryTxt要将数据传给Activity,只要调用 实现接口的Activity中的setTxt

 */

public class MainActivity extends Activity implements BatteryChange.setBatteryText {

    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_item);

        text = (TextView) findViewById(R.id.text3);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
        BatteryChange batteryChange = new BatteryChange();
        //注册广播接收器
        registerReceiver(batteryChange,intentFilter);
        //把当前对象传给BatteryChange
        batteryChange.getBatteryText(this);

    }
    public void setTxt(String a){
        if(a!=null){
            text.setText(a);
            Log.d("MainActivity",a);
        }
    }

}

