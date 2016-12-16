package com.chiemy.demo.decorationarchives.ui.adaoter;

import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chiemy.demo.decorationarchives.model.Article;

/**
 * Created: chiemy
 * Date: 16/12/16
 * Description:
 */

public class ArticleListAdapter extends BaseQuickAdapter<Article> {

    public ArticleListAdapter() {
        super(android.R.layout.simple_list_item_1, null);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, Article article) {
        baseViewHolder.itemView.setTag(article);
        ((TextView) baseViewHolder.itemView).setText(article.name);
    }
}
