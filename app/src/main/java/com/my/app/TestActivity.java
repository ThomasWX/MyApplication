package com.my.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doClick(View view){
        Intent intent = new Intent("cn.nubia.contacts.action.MULTI_PICK_CONTACTS");
        intent.putExtra("extra_count", 10);
        startActivityForResult(intent, 100);
    }
}
