package com.hc.layout;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_layout_basis).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, LayoutPracticeActivity.class);
        switch (view.getId()) {
            case R.id.btn_layout_basis:
                intent.putExtra(ModuleConfiguration.KEY_MODULE_CONFIGURATION, ModuleConfiguration.MODULE_LAYOUT_BASIS);
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
