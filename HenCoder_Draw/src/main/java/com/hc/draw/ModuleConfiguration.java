package com.hc.draw;

import androidx.annotation.LayoutRes;
import androidx.annotation.StringRes;

import java.util.ArrayList;
import java.util.List;

public class ModuleConfiguration {
    public static String KEY_MODULE_CONFIGURATION = "key.module.configuration";
    public static final int MODULE_DRAWING_BASIC = 1;
    public static final int MODULE_PAINT = 2;
    public static final int MODULE_DRAW_TEXT = 3;
    public static final int MODULE_CANVAS_ASSISTED_DRAWING = 4;
    public static final int MODULE_DRAWING_ORDER = 5;
    public static final int MODULE_PROPERTY_ANIMATION_FIRST = 6;

    private List<PageModel> pageModels = new ArrayList<>();


    public List<PageModel> getPageModels(int module) {
        pageModels.clear();
        switch (module) {
            case MODULE_DRAWING_BASIC:
                pageModels.add(new PageModel(R.layout.sample_color, R.string.title_draw_color, R.layout.practice_color));
                pageModels.add(new PageModel(R.layout.sample_circle, R.string.title_draw_circle, R.layout.practice_circle));
                pageModels.add(new PageModel(R.layout.sample_rect, R.string.title_draw_rect, R.layout.practice_rect));
                pageModels.add(new PageModel(R.layout.sample_point, R.string.title_draw_point, R.layout.practice_point));
                pageModels.add(new PageModel(R.layout.sample_oval, R.string.title_draw_oval, R.layout.practice_oval));
                pageModels.add(new PageModel(R.layout.sample_line, R.string.title_draw_line, R.layout.practice_line));
                pageModels.add(new PageModel(R.layout.sample_round_rect, R.string.title_draw_round_rect, R.layout.practice_round_rect));
                pageModels.add(new PageModel(R.layout.sample_arc, R.string.title_draw_arc, R.layout.practice_arc));
                pageModels.add(new PageModel(R.layout.sample_path, R.string.title_draw_path, R.layout.practice_path));
                pageModels.add(new PageModel(R.layout.sample_histogram, R.string.title_draw_histogram, R.layout.practice_histogram));
                pageModels.add(new PageModel(R.layout.sample_pie_chart, R.string.title_draw_pie_chart, R.layout.practice_pie_chart));
                break;
            case MODULE_PAINT:
                pageModels.add(new PageModel(R.layout.sample_linear_gradient, R.string.title_linear_gradient, R.layout.practice_linear_gradient));
                pageModels.add(new PageModel(R.layout.sample_radial_gradient, R.string.title_radial_gradient, R.layout.practice_radial_gradient));
                pageModels.add(new PageModel(R.layout.sample_sweep_gradient, R.string.title_sweep_gradient, R.layout.practice_sweep_gradient));
                pageModels.add(new PageModel(R.layout.sample_bitmap_shader, R.string.title_bitmap_shader, R.layout.practice_bitmap_shader));
                pageModels.add(new PageModel(R.layout.sample_compose_shader, R.string.title_compose_shader, R.layout.practice_compose_shader));
                pageModels.add(new PageModel(R.layout.sample_lighting_color_filter, R.string.title_lighting_color_filter, R.layout.practice_lighting_color_filter));
                pageModels.add(new PageModel(R.layout.sample_color_mask_color_filter, R.string.title_color_matrix_color_filter, R.layout.practice_color_matrix_color_filter));
                pageModels.add(new PageModel(R.layout.sample_xfermode, R.string.title_xfermode, R.layout.practice_xfermode));
                pageModels.add(new PageModel(R.layout.sample_stroke_cap, R.string.title_stroke_cap, R.layout.practice_stroke_cap));
                pageModels.add(new PageModel(R.layout.sample_stroke_join, R.string.title_stroke_join, R.layout.practice_stroke_join));
                pageModels.add(new PageModel(R.layout.sample_stroke_miter, R.string.title_stroke_miter, R.layout.practice_stroke_miter));
                pageModels.add(new PageModel(R.layout.sample_path_effect, R.string.title_path_effect, R.layout.practice_path_effect));
                pageModels.add(new PageModel(R.layout.sample_shadow_layer, R.string.title_shader_layer, R.layout.practice_shadow_layer));
                pageModels.add(new PageModel(R.layout.sample_mask_filter, R.string.title_mask_filter, R.layout.practice_mask_filter));
                pageModels.add(new PageModel(R.layout.sample_fill_path, R.string.title_fill_path, R.layout.practice_fill_path));
                pageModels.add(new PageModel(R.layout.sample_text_path, R.string.title_text_path, R.layout.practice_text_path));
                break;
            case MODULE_DRAW_TEXT:
                pageModels.add(new PageModel(R.layout.sample_draw_text, R.string.title_draw_text, R.layout.practice_draw_text));
                pageModels.add(new PageModel(R.layout.sample_static_layout, R.string.title_static_layout, R.layout.practice_static_layout));
                pageModels.add(new PageModel(R.layout.sample_set_text_size, R.string.title_set_text_size, R.layout.practice_set_text_size));
                pageModels.add(new PageModel(R.layout.sample_set_typeface, R.string.title_set_typeface, R.layout.practice_set_typeface));
                pageModels.add(new PageModel(R.layout.sample_set_fake_bold_text, R.string.title_set_fake_bold_text, R.layout.practice_set_fake_bold_text));
                pageModels.add(new PageModel(R.layout.sample_set_strike_thru_text, R.string.title_set_strike_thru_text, R.layout.practice_set_strike_thru_text));
                pageModels.add(new PageModel(R.layout.sample_set_underline_text, R.string.title_set_underline_text, R.layout.practice_set_underline_text));
                pageModels.add(new PageModel(R.layout.sample_set_text_skew_x, R.string.title_set_text_skew_x, R.layout.practice_set_text_skew_x));
                pageModels.add(new PageModel(R.layout.sample_set_text_scale_x, R.string.title_set_text_scale_x, R.layout.practice_set_text_scale_x));
                pageModels.add(new PageModel(R.layout.sample_set_text_align, R.string.title_set_text_align, R.layout.practice_set_text_align));
                pageModels.add(new PageModel(R.layout.sample_get_font_spacing, R.string.title_get_font_spacing, R.layout.practice_get_font_spacing));
                pageModels.add(new PageModel(R.layout.sample_measure_text, R.string.title_measure_text, R.layout.practice_measure_text));
                pageModels.add(new PageModel(R.layout.sample_get_text_bounds, R.string.title_get_text_bounds, R.layout.practice_get_text_bounds));
                pageModels.add(new PageModel(R.layout.sample_get_font_metrics, R.string.title_get_font_metrics, R.layout.practice_get_font_metrics));
                break;
            case MODULE_CANVAS_ASSISTED_DRAWING:
                pageModels.add(new PageModel(R.layout.sample_clip_rect, R.string.title_clip_rect, R.layout.practice_clip_rect));
                pageModels.add(new PageModel(R.layout.sample_clip_path, R.string.title_clip_path, R.layout.practice_clip_path));
                pageModels.add(new PageModel(R.layout.sample_translate, R.string.title_translate, R.layout.practice_translate));
                pageModels.add(new PageModel(R.layout.sample_scale, R.string.title_scale, R.layout.practice_scale));
                pageModels.add(new PageModel(R.layout.sample_rotate, R.string.title_rotate, R.layout.practice_rotate));
                pageModels.add(new PageModel(R.layout.sample_skew, R.string.title_skew, R.layout.practice_skew));
                pageModels.add(new PageModel(R.layout.sample_matrix_translate, R.string.title_matrix_translate, R.layout.practice_matrix_translate));
                pageModels.add(new PageModel(R.layout.sample_matrix_scale, R.string.title_matrix_scale, R.layout.practice_matrix_scale));
                pageModels.add(new PageModel(R.layout.sample_matrix_rotate, R.string.title_matrix_rotate, R.layout.practice_matrix_rotate));
                pageModels.add(new PageModel(R.layout.sample_matrix_skew, R.string.title_matrix_skew, R.layout.practice_matrix_skew));
                pageModels.add(new PageModel(R.layout.sample_camera_rotate, R.string.title_camera_rotate, R.layout.practice_camera_rotate));
                pageModels.add(new PageModel(R.layout.sample_camera_rotate_fixed, R.string.title_camera_rotate_fixed, R.layout.practice_measure_text2));
                pageModels.add(new PageModel(R.layout.sample_camera_rotate_hitting_face, R.string.title_camera_rotate_hitting_face, R.layout.practice_camera_rotate_hitting_face));
                pageModels.add(new PageModel(R.layout.sample_flipboard, R.string.title_flipboard, R.layout.practice_flipboard));
                break;
            case MODULE_DRAWING_ORDER:
                pageModels.add(new PageModel(R.layout.sample_after_on_draw, R.string.title_after_on_draw, R.layout.practice_after_on_draw));
                pageModels.add(new PageModel(R.layout.sample_before_on_draw, R.string.title_before_on_draw, R.layout.practice_before_on_draw));
                pageModels.add(new PageModel(R.layout.sample_on_draw_layout, R.string.title_on_draw_layout, R.layout.practice_on_draw_layout));
                pageModels.add(new PageModel(R.layout.sample_dispatch_draw, R.string.title_dispatch_draw, R.layout.practice_dispatch_draw));
                pageModels.add(new PageModel(R.layout.sample_after_on_draw_foreground, R.string.title_after_on_draw_foreground, R.layout.practice_after_on_draw_foreground));
                pageModels.add(new PageModel(R.layout.sample_before_on_draw_foreground, R.string.title_before_on_draw_foreground, R.layout.practice_before_on_draw_foreground));
                pageModels.add(new PageModel(R.layout.sample_after_draw, R.string.title_after_draw, R.layout.practice_after_draw));
                pageModels.add(new PageModel(R.layout.sample_before_draw, R.string.title_before_draw, R.layout.practice_before_draw));
                break;
            case MODULE_PROPERTY_ANIMATION_FIRST:
                pageModels.add(new PageModel(R.layout.sample_translation, R.string.title_translation, R.layout.practice_translation));
                pageModels.add(new PageModel(R.layout.sample_rotation, R.string.title_rotation, R.layout.practice_rotation));
                pageModels.add(new PageModel(R.layout.sample_scale2, R.string.title_scale, R.layout.practice_scale2));
                pageModels.add(new PageModel(R.layout.sample_alpha, R.string.title_alpha, R.layout.practice_alpha));
                pageModels.add(new PageModel(R.layout.sample_multi_properties, R.string.title_multi_properties, R.layout.practice_multi_properties));
                pageModels.add(new PageModel(R.layout.sample_duration, R.string.title_duration, R.layout.practice_duration));
                pageModels.add(new PageModel(R.layout.sample_interpolator, R.string.title_interpolator, R.layout.practice_interpolator));
                pageModels.add(new PageModel(R.layout.sample_object_anomator, R.string.title_object_animator, R.layout.practice_object_animator));
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
