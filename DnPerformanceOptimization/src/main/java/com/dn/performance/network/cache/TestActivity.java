package com.dn.performance.network.cache;

import android.net.http.HttpResponseCache;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.dn.performance.R;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;


public class TestActivity extends AppCompatActivity {
    private Button mRequestBtn, mOpenCacheBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_cache_test);
        mRequestBtn = findViewById(R.id.button1);
        mOpenCacheBtn = findViewById(R.id.button2);
        mRequestBtn.setOnClickListener(mRequestClick);
        mOpenCacheBtn.setOnClickListener(mOpenCacheClick);
    }

    private View.OnClickListener mRequestClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            new Thread(new Runnable() {
                String url = "";
                @Override
                public void run() {
                    try {
                        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
                        // 服务器使用TomCat, Servlet.
                        connection.setRequestMethod("GET");
                        connection.setDoInput(true);
                        if (connection.getResponseCode() == 200){

                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    };

    private View.OnClickListener mOpenCacheClick = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            // Android 系统默认的HttpResponseCache(网络请求响应缓存)是关闭的。
            // 开启缓存之后，在Cache目录下创建http文件夹，HttpResponseCache将缓存所有的返回信息。
            File cacheDir = new File(getCacheDir(),"http");// 缓存目录
            try {
                HttpResponseCache.install(cacheDir, 10 * 1024 * 1024); // 缓存单位byte
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };
}
