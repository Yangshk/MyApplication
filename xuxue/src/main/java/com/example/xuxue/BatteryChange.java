package com.example.xuxue;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import java.net.InterfaceAddress;

public class BatteryChange extends BroadcastReceiver {

    private setBatteryText setBattery;

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();

        //获取当前电量
        int l = bundle.getInt("level");
        //温度
        int t= bundle.getInt("temperature");
        int tt = (int) (t*0.1);
        //获取总电量（电池的电池容量）
        int s = bundle.getInt("scale");
        setBattery.setTxt(" 剩余电量:"+l+"%"+",总电量:"+s+"。"+"电池的温度："+tt);

    }
    public interface setBatteryText{
        void setTxt(String a);
    }
    public void getBatteryText(setBatteryText setBattery  ){
        this.setBattery = setBattery;
    }
}