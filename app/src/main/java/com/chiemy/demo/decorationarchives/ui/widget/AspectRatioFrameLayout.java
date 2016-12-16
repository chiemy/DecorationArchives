package com.chiemy.demo.decorationarchives.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.chiemy.demo.decorationarchives.R;

/**
 * Created: chiemy
 * Date: 16/12/16
 * Description: 可设置宽高比的FrameLayout, 宽以实际为准, 高度按照 aspect_ratio 计算后得出。<br>
 *     举例 aspect_ratio = 1, 则为正方形; aspect_ratio = 2, 则高度为宽度的2倍
 */

public class AspectRatioFrameLayout extends FrameLayout {
    private float mAspectRatio;

    public AspectRatioFrameLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AspectRatioFrameLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // Load attributes
        final TypedArray a = getContext().obtainStyledAttributes(
                attrs, R.styleable.AspectRatioFrameLayout, defStyle, 0);
        mAspectRatio = a.getFloat(R.styleable.AspectRatioFrameLayout_aspect_ratio, 0);
        a.recycle();
    }


    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {
        if (mAspectRatio > 0) {
            heightSpec = MeasureSpec.makeMeasureSpec((int) (MeasureSpec.getSize(widthSpec) * mAspectRatio),
                    MeasureSpec.EXACTLY);
        }
        super.onMeasure(widthSpec, heightSpec);
    }
}
