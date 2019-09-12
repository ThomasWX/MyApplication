package com.my.listView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.my.app.R;

public class LVTestActivity extends AppCompatActivity {
    private ReboundEffectListView mListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lv_test);
        mListView = findViewById(R.id.rebound_list_view);
        String[] data = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,data);
        mListView.setAdapter(adapter);
    }


}
