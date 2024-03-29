package com.hc.draw.module6;

import android.content.Context;
import android.graphics.Outline;
import android.graphics.Path;
import android.os.Build;

import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.hc.draw.R;
import com.hc.draw.Utils;


import static android.os.Build.VERSION.SDK_INT;
import static com.hc.draw.Utils.dpToPixel;


public class Sample01Translation extends RelativeLayout {
    Button animateBt;
    ImageView imageView;

    int translationStateCount = SDK_INT > Build.VERSION_CODES.LOLLIPOP ? 6 : 4;
    int translationState = 0;

    public Sample01Translation(Context context) {
        super(context);
    }

    public Sample01Translation(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Sample01Translation(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        animateBt = (Button) findViewById(R.id.animateBt);
        imageView = (ImageView) findViewById(R.id.imageView);
        if (SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            // 给音乐图标加上合适的阴影
            imageView.setOutlineProvider(new MusicOutlineProvider());
        }

        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View v) {
                switch (translationState) {
                    case 0:
                        imageView.animate().translationX(dpToPixel(100));
                        break;
                    case 1:
                        imageView.animate().translationX(0);
                        break;
                    case 2:
                        imageView.animate().translationY(dpToPixel(50));
                        break;
                    case 3:
                        imageView.animate().translationY(0);
                        break;
                    case 4:
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            imageView.animate().translationZ(dpToPixel(15));
                        }
                        break;
                    case 5:
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            imageView.animate().translationZ(0);
                        }
                        break;
                }
                translationState++;
                if (translationState == translationStateCount) {
                    translationState = 0;
                }
            }
        });
    }

    /**
     * 为音乐图标设置三角形的 Outline。
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    class MusicOutlineProvider extends ViewOutlineProvider {
        Path path = new Path();

        {
            path.moveTo(0, dpToPixel(10));
            path.lineTo(dpToPixel(7), dpToPixel(2));
            path.lineTo(dpToPixel(116), dpToPixel(58));
            path.lineTo(dpToPixel(116), dpToPixel(70));
            path.lineTo(dpToPixel(7), dpToPixel(128));
            path.lineTo(0, dpToPixel(120));
            path.close();
        }

        @Override
        public void getOutline(View view, Outline outline) {
            outline.setConvexPath(path);
        }
    }
}