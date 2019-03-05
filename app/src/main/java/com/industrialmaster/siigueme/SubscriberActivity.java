package com.industrialmaster.siigueme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SubscriberActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscriber);
    }

    public void onAddSubClick(View view){
        Intent intent = new Intent(getApplicationContext(), AddSubscriberActivity.class);
        startActivity(intent);
    }

    public void onSubProfileClick(View view){
        Intent intent = new Intent(getApplicationContext(), SubProfileActivity.class);
        startActivity(intent);
    }
}
