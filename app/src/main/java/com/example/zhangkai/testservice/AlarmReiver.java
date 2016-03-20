package com.example.zhangkai.testservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by zhangkai on 2016/3/20.
 */
public class AlarmReiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        intent.setClass(context, MyService.class);
        context.startService(intent);
    }
}
