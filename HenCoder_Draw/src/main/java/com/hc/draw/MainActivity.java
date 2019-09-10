package com.hc.draw;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button drawBasic = findViewById(R.id.btn_draw_basic);
        drawBasic.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.btn_draw_basic:
                intent.setClass(this, DrawingBasisActivity.class);
                break;
            default:
                break;
        }
        try {
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
