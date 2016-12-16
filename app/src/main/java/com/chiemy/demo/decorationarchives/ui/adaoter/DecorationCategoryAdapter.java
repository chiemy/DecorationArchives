package com.chiemy.demo.decorationarchives.ui.adaoter;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chiemy.demo.decorationarchives.R;
import com.chiemy.demo.decorationarchives.model.DecorationCategory;
import com.chiemy.demo.decorationarchives.utils.ImageLoader;

/**
 * Created: chiemy
 * Date: 16/12/16
 * Description:
 */

public class DecorationCategoryAdapter extends BaseQuickAdapter<DecorationCategory> {

    public DecorationCategoryAdapter() {
        super(R.layout.item_decoration_category, null);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, DecorationCategory decorationCategory) {
        baseViewHolder.itemView.setTag(decorationCategory);
        baseViewHolder.setText(R.id.tv_category_name, decorationCategory.name);
        ImageLoader.load(R.mipmap.ic_launcher, (ImageView) baseViewHolder.getView(R.id.iv_category));
    }
}
