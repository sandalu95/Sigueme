package com.industrialmaster.siigueme;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.BatteryManager;
import android.telephony.SmsManager;

import static android.content.Context.MODE_PRIVATE;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        float batteryPct;
        int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);

        if(level == -1 || scale == -1) {
            batteryPct = 50.0f;
        }

        batteryPct = ((float) level/(float) scale)*100.0f;

        String receiverNo = null;

        if(batteryPct<=10.0f){
            SharedPreferences prefs = context.getSharedPreferences("MyPrefsFile", MODE_PRIVATE);
            receiverNo = prefs.getString("RecieverNo", "0776931433");

            String smsMessage = "Phone battery level :" + batteryPct;

            String scAddress = null;
            PendingIntent sentIntent = null, deliveryIntent = null;

            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(receiverNo, scAddress, smsMessage, sentIntent, deliveryIntent);
        }
    }
}
