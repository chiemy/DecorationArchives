package com.chiemy.demo.decorationarchives.ui.widget;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created: chiemy
 * Date: 16/10/28
 * Description:
 */

public class CommonGridItemDecoration extends RecyclerView.ItemDecoration {

    private int mVerticalSpacing;
    private int mHeadercount;
    private int mSpanCount;
    private int mHalfHorizontalSpacing;


    public CommonGridItemDecoration(int spanCount,
                                    int headerCount,
                                    int verticalSpacing,
                                    int horizontalSpacing) {
        mSpanCount = spanCount;
        mVerticalSpacing = verticalSpacing;
        mHalfHorizontalSpacing = horizontalSpacing / 2;
        mHeadercount = headerCount;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if (parent.getChildLayoutPosition(view) < mHeadercount) {
            return;
        }
        outRect.left = mHalfHorizontalSpacing;
        outRect.right = mHalfHorizontalSpacing;
        outRect.bottom = mVerticalSpacing;
        outRect.top = 0;
    }
}
