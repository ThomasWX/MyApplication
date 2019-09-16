package com.my.app;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;

import java.util.Arrays;

public class TestActivity extends View {

    public TestActivity(Context context) {
        super(context);
        int[] a = new int[1];
        Arrays.toString(a);

    }



//    public static int resolveSize(int size, int measureSpec) {
//        final int specMode = MeasureSpec.getMode(measureSpec);
//        final int specSize = MeasureSpec.getSize(measureSpec);
//
//        switch (specMode) {
//            case MeasureSpec.UNSPECIFIED:
//                return size;
//            case MeasureSpec.AT_MOST:
//                if (size <= specSize) {
//                    return size;
//                } else {
//                    return specSize;
//                }
//            case MeasureSpec.EXACTLY:
//                return specSize;
//            default:
//                return size;
//        }
//    }


}
