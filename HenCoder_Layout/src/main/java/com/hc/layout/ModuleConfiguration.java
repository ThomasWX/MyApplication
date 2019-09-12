package com.hc.layout;

import androidx.annotation.LayoutRes;
import androidx.annotation.StringRes;

import java.util.ArrayList;
import java.util.List;

public class ModuleConfiguration {
    public static String KEY_MODULE_CONFIGURATION = "key.module.configuration";
    public static final int MODULE_LAYOUT_BASIS = 1;
    private List<PageModel> pageModels = new ArrayList<>();


    public List<PageModel> getPageModels(int module) {
        pageModels.clear();
        switch (module) {
            case MODULE_LAYOUT_BASIS:
                pageModels.add(new PageModel(R.layout.sample_square_image_view, R.string.title_square_image_view, R.layout.practice_square_image_view));
                break;
            default:
                break;
        }
        return pageModels;
    }

    public class PageModel {
        @LayoutRes
        int sampleLayoutRes;
        @StringRes
        int titleRes;
        @LayoutRes
        int practiceLayoutRes;

        PageModel(@LayoutRes int sampleLayoutRes, @StringRes int titleRes, @LayoutRes int practiceLayoutRes) {
            this.sampleLayoutRes = sampleLayoutRes;
            this.titleRes = titleRes;
            this.practiceLayoutRes = practiceLayoutRes;
        }
    }
}
