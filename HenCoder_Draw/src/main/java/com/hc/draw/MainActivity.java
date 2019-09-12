package com.hc.draw;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_draw_basic).setOnClickListener(this);
        findViewById(R.id.btn_paint).setOnClickListener(this);
        findViewById(R.id.btn_draw_text).setOnClickListener(this);
        findViewById(R.id.btn_canvas_assisted).setOnClickListener(this);
        findViewById(R.id.btn_drawing_order).setOnClickListener(this);
        findViewById(R.id.btn_property_animation_first).setOnClickListener(this);
        findViewById(R.id.btn_property_animation_next).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, DrawingPracticeActivity.class);
        switch (view.getId()) {
            case R.id.btn_draw_basic:
                intent.putExtra(ModuleConfiguration.KEY_MODULE_CONFIGURATION, ModuleConfiguration.MODULE_DRAWING_BASIC);
                break;
            case R.id.btn_paint:
                intent.putExtra(ModuleConfiguration.KEY_MODULE_CONFIGURATION, ModuleConfiguration.MODULE_PAINT);
                break;
            case R.id.btn_draw_text:
                intent.putExtra(ModuleConfiguration.KEY_MODULE_CONFIGURATION, ModuleConfiguration.MODULE_DRAW_TEXT);
                break;
            case R.id.btn_canvas_assisted:
                intent.putExtra(ModuleConfiguration.KEY_MODULE_CONFIGURATION, ModuleConfiguration.MODULE_CANVAS_ASSISTED_DRAWING);
                break;
            case R.id.btn_drawing_order:
                intent.putExtra(ModuleConfiguration.KEY_MODULE_CONFIGURATION, ModuleConfiguration.MODULE_DRAWING_ORDER);
                break;
            case R.id.btn_property_animation_first:
                intent.putExtra(ModuleConfiguration.KEY_MODULE_CONFIGURATION, ModuleConfiguration.MODULE_PROPERTY_ANIMATION_FIRST);
                break;
            case R.id.btn_property_animation_next:
                intent.putExtra(ModuleConfiguration.KEY_MODULE_CONFIGURATION, ModuleConfiguration.MODULE_PROPERTY_ANIMATION_NEXT);
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
