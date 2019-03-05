package com.industrialmaster.siigueme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onGetStartedClick(View view){
        Intent intent = new Intent(getApplicationContext(), SubscriberActivity.class);
        startActivity(intent);
    }
}
