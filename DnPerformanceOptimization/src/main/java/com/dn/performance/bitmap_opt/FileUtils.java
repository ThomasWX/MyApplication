package com.dn.performance.bitmap_opt;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

import java.io.*;

public class FileUtils {

    public static void saveBitmapToFile(@NonNull Bitmap bitmap, File file) {
        BufferedOutputStream bos = null;
        try {
            bos = new BufferedOutputStream(new FileOutputStream(file));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bos);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
