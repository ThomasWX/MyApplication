package com.dn.performance.bitmap_opt.quality_compression;

import android.graphics.Bitmap;

import java.io.*;

public class QualityCompressModel {
    /**
     * 质量压缩
     * 使用Bitmap的API : public boolean compress(Bitmap.CompressFormat format, int quality, OutputStream stream)
     * 降低图片的质量，像素不会减少
     */
    public static void qualityCompress(Bitmap bitmap, File file) {

        int quality = 20; // 0~100，100为不压缩
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, quality, bos); // 把压缩后的数据存放到 bos 中。

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            fos.write(bos.toByteArray());
            fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void compressTest(Bitmap bitmap, File file) {
        int quality = 20; // 0~100，100为不压缩
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, quality, fos);
            fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
