package com.dn.performance.bitmap_opt.sample_rate_compression;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.dn.performance.bitmap_opt.FileUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;

public class SampleRateCompressModel {

    /**
     * 设置图片的采样率，降低图片像素
     */
    public static void compress(Bitmap bitmap, File file) {
        // 数值越高，图片像素越低
        int sampleRate = 8;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false; // 为 true 的时候不会真正加载图片，而是得到图片的宽高信息
        options.inSampleSize = sampleRate; // 设置采样率

        // 将Bitmap 转成InputStream
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bos);

        Bitmap target = BitmapFactory.decodeStream(new ByteArrayInputStream(bos.toByteArray()), null, options);
        if (target != null)
            FileUtils.saveBitmapToFile(target, file);
    }
}
