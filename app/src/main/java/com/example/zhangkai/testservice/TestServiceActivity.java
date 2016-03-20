package com.example.zhangkai.testservice;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TestServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_service);

        long starttime = SystemClock.elapsedRealtime();
        startLocationUpService(starttime);
    }

    private void startLocationUpService(long starttime)
    {
//        MqttConnection connection = MqttConnection.createMqttConnection(Constants.MQTTTOPIC, Constants.MQTTBROKERHOST,Constants.MQTTBROKERPORT,this.getApplicationContext(),false);
//        connection.connect(0);
//        MqttConnections.getInstance().addConnection(connection);

        Intent i = new Intent(this, AlarmReiver.class);

        Bundle bundle = new Bundle();
        i.putExtras(bundle);

        PendingIntent pi = PendingIntent.getBroadcast(this, 0, i, 0);
        AlarmManager mgr = (AlarmManager) getSystemService(ALARM_SERVICE);
        mgr.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                starttime,
                30000,
                pi);

//        long firstMillis = System.currentTimeMillis();

//        mgr.setInexactRepeating(AlarmManager.RTC_WAKEUP,firstMillis,Constants.LOCATIONPERIOD,pi);
//        mgr.setInexactRepeating(AlarmManager.RTC_WAKEUP,firstMillis+Constants.LOCATIONGPSTIMEOUT,Constants.LOCATIONPERIOD,pi);
    }
}
