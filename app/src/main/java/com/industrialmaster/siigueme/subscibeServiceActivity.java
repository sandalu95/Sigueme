package com.industrialmaster.siigueme;

import android.app.Activity;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.support.v4.content.LocalBroadcastManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class subscibeServiceActivity extends Activity {

    public static final String MY_PREFS_NAME = "MyPrefsFile";

    String recieverNo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscibe_service);

        recieverNo = getIntent().getExtras().getString("recieverNo");
    }

    public void addService(View view){
        SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
        editor.putString("RecieverNo", recieverNo);
        editor.apply();

        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.BATTERY_CHANGED");

        MyReceiver receiver = new MyReceiver();

        registerReceiver(receiver,filter);

        Toast.makeText(this, "Subscribed", Toast.LENGTH_SHORT).show();
    }

    public void removeSubscriber(View View){
        MyReceiver receiver = new MyReceiver();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(receiver);
        Toast.makeText(this, "Unsubscribed", Toast.LENGTH_SHORT).show();
    }
}
