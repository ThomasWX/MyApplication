package com.my.recyclerView;

import android.animation.Animator;
import android.animation.IntEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ReboundEffectRecyclerView extends RecyclerView {
    private static final String TAG = "ReboundEffectRecyclerView";
    private static final int OVERLOAD_TOP_MAX_PIXEL = 300;
    private static final int OVERLOAD_BOTTOM_MAX_PIXEL = -300;
    private Context context;

    public ReboundEffectRecyclerView(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    private ScaleGestureDetector mScaleGestureDetector;
    private ScaleGestureDetector.OnScaleGestureListener mOnScaleGestureListener;

    private int mLastVisiblePosition = -1;
    private int mClickedPosition = -1;
    private int mCurrentY;
    private int mLastY;
    private boolean isOnTop = false;
    private boolean isOnBottom = false;

    private ValueAnimator animator;


    @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {
        mLastY = (int) e.getRawY();
        switch (e.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                break;
            default:
                mLastY = 0;
                break;
        }
        boolean result = super.onInterceptTouchEvent(e);
        Log.d(TAG, "onInterceptTouchEvent() returned: " + result + " | mLastY = " + mLastY);
        return result;

    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        if (mScaleGestureDetector == null) {
            initScaleListener(context);
        }
        int count = e.getPointerCount();
        boolean result;

        if (count == 2) {
            result = mScaleGestureDetector.onTouchEvent(e);
            Log.d(TAG, "ScaleGestureDetector onTouchEvent result :" + result);
            return result;
        }
        if (animator == null) {
            initAnim();
        }
        final FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) getLayoutParams();
        switch (e.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                mLastY = (int) e.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                if (handleMoveEvent(lp, e)) return true;
                break;

            case MotionEvent.ACTION_UP:
                handleUpEvent(lp);
                break;
        }

        result = super.onTouchEvent(e);
        Log.d(TAG, "onTouchEvent() returned: " + result);
        return result;
    }

    private void initScaleListener(Context context) {
        mScaleGestureDetector = new ScaleGestureDetector(context, mOnScaleGestureListener);
    }

    private void initAnim() {
        // 添加拉伸动画
        animator = ValueAnimator.ofInt(OVERLOAD_TOP_MAX_PIXEL, 0);
        PathInterpolator interpolator = new PathInterpolator(0.2f, 0.22f, 0.17f, 1.0f);
        animator.setInterpolator(interpolator);
    }

    private boolean handleMoveEvent(FrameLayout.LayoutParams layoutParams, MotionEvent event) {

        int firstChildTop = Integer.MIN_VALUE;
        int lastChildBottom = Integer.MIN_VALUE;
        LinearLayoutManager layoutManager = (LinearLayoutManager) getLayoutManager();
        if (layoutManager != null) {
            int firstCompletelyVisibleItemPosition = layoutManager.findFirstCompletelyVisibleItemPosition();

            if (firstCompletelyVisibleItemPosition == 0) {
                isOnTop = true;
                View item = getChildAt(firstCompletelyVisibleItemPosition);
                if (item != null) {
                    firstChildTop = item.getTop();
                }
                Log.d(TAG, "onTouchEvent: 滑动到顶部 firstChildTop = " + firstChildTop);
            } else {
                isOnTop = false;
            }

            int lastCompletelyVisibleItemPosition = layoutManager.findLastCompletelyVisibleItemPosition();


            if (lastCompletelyVisibleItemPosition == layoutManager.getItemCount() - 1) {
                isOnBottom = true;
                View item = getChildAt(lastCompletelyVisibleItemPosition - 1);
                if (item != null) {
                    lastChildBottom = item.getBottom();
                }
                Log.d(TAG, "onTouchEvent: 滑动到底部 lastChildBottom = " + lastChildBottom);
            } else {
                isOnBottom = false;
            }
        }
        Log.d(TAG, "onTouchEvent: isOnTop = " + isOnTop + ", isOnBottom = " + isOnBottom);

        int y = (int) event.getRawY();
        int dy = y - mLastY;
        Log.d(TAG, "onTouchEvent: y = " + y + ", mLastY = " + mLastY + ", dy = " + dy);
        mLastY = y;
        Log.d(TAG, "onTouchEvent: getTop() = " + getTop() + ", getBottom() = " + getBottom());

        if (isOnTop && isOnBottom) {
            if (dy < 0 && layoutParams.bottomMargin >= 0) {
                layoutParams.bottomMargin -= dy / 2;
                if (layoutParams.bottomMargin < 0) {
                    layoutParams.bottomMargin = 0;
                } else if (layoutParams.bottomMargin >= OVERLOAD_TOP_MAX_PIXEL) {
                    layoutParams.bottomMargin = OVERLOAD_TOP_MAX_PIXEL;
                }
                Log.d(TAG, "onTouchEvent: layoutParams.bottomMargin = " + layoutParams.bottomMargin);
                setLayoutParams(layoutParams);
                if (layoutParams.bottomMargin > 0) {
                    return true;
                }
            } else if (dy > 0 && layoutParams.topMargin >= 0 && getTop() <= 0) {
                layoutParams.topMargin += dy / 2;
                if (layoutParams.topMargin < 0) {
                    layoutParams.topMargin = 0;
                } else if (layoutParams.topMargin >= OVERLOAD_TOP_MAX_PIXEL) {
                    layoutParams.topMargin = OVERLOAD_TOP_MAX_PIXEL;
                }
                Log.d(TAG, "onTouchEvent: layoutParams.topMargin = " + layoutParams.topMargin);
                setLayoutParams(layoutParams);
                if (layoutParams.topMargin > 0) {
                    return true;
                }
            }
        } else if (isOnTop) {
            Log.d(TAG, "onTouchEvent: 在顶部, dy = " + dy);
            layoutParams.topMargin += dy / 2;
            if (layoutParams.topMargin < 0) {
                layoutParams.topMargin = 0;
            } else if (layoutParams.topMargin >= OVERLOAD_TOP_MAX_PIXEL) {
                layoutParams.topMargin = OVERLOAD_TOP_MAX_PIXEL;
            }
            layoutParams.bottomMargin = -layoutParams.topMargin;
            Log.d(TAG, "onTouchEvent: layoutParams.topMargin = " + layoutParams.topMargin);
            setLayoutParams(layoutParams);
            if (layoutParams.topMargin > 0) {
                return true;
            }
        } else if (isOnBottom) {
            Log.d(TAG, "onTouchEvent: 在底部, dy = " + dy);

            layoutParams.bottomMargin -= dy / 2;
            if (layoutParams.bottomMargin < 0) {
                layoutParams.bottomMargin = 0;
            } else if (layoutParams.bottomMargin >= OVERLOAD_TOP_MAX_PIXEL) {
                layoutParams.bottomMargin = OVERLOAD_TOP_MAX_PIXEL;
            }
            layoutParams.topMargin = -layoutParams.bottomMargin;
            Log.d(TAG, "onTouchEvent: layoutParams.bottomMargin = " + layoutParams.bottomMargin);
            setLayoutParams(layoutParams);
            if (layoutParams.bottomMargin > 0) {
                return true;
            }
        }
        mLastY = y;


        return false;
    }

    private void handleUpEvent(final FrameLayout.LayoutParams layoutParams) {
        Log.d(TAG, "onTouchEvent: layoutParams.topMargin = " + layoutParams.topMargin + ", layoutParams.bottomMargin = " + layoutParams.bottomMargin);
        if (layoutParams.topMargin != 0 || layoutParams.bottomMargin != 0) {
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                private IntEvaluator evaluator = new IntEvaluator();

                @Override
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (layoutParams.topMargin != 0) {
                        layoutParams.topMargin = evaluator.evaluate(valueAnimator.getAnimatedFraction(), layoutParams.topMargin, 0);
                    }
                    if (layoutParams.bottomMargin != 0) {
                        layoutParams.bottomMargin = evaluator.evaluate(valueAnimator.getAnimatedFraction(), layoutParams.bottomMargin, 0);
                    }
                    Log.d(TAG, "onAnimationUpdate: layoutParams.topMargin = " + layoutParams.topMargin + ", layoutParams.bottomMargin = " + layoutParams.bottomMargin);
                    setLayoutParams(layoutParams);
                }
            });
            animator.start();
        }

        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                // playReboundSound();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        mLastY = 0;
    }
}
