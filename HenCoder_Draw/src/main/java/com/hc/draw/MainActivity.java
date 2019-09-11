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

        Button paint = findViewById(R.id.btn_paint);
        paint.setOnClickListener(this);

        Button drawText = findViewById(R.id.btn_draw_text);
        drawText.setOnClickListener(this);

        Button canvasAssisted = findViewById(R.id.btn_canvas_assisted);
        canvasAssisted.setOnClickListener(this);

        Button drawOrder = findViewById(R.id.btn_drawing_order);
        drawOrder.setOnClickListener(this);

        Button propertyAnimationFirst = findViewById(R.id.btn_property_animation_first);
        propertyAnimationFirst.setOnClickListener(this);
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
