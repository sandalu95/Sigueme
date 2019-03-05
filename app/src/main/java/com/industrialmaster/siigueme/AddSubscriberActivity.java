package com.industrialmaster.siigueme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.EditText;

public class AddSubscriberActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_subscriber);
    }

    public void AddSubscriber(View view){
        EditText nameSubscriber = (AppCompatEditText) findViewById(R.id.nameTxt);
        EditText relationSubscriber = (AppCompatEditText) findViewById(R.id.relationTxt);
        EditText contactSubscriber = (AppCompatEditText) findViewById(R.id.contactTxt);
        String recieverNo = contactSubscriber.getText().toString();

        Intent intent = new Intent(getApplicationContext(), subscibeServiceActivity.class);
        intent.putExtra("recieverNo",recieverNo);
        startActivity(intent);
    }
}
