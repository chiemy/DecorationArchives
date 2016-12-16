package com.chiemy.demo.decorationarchives.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chiemy.demo.decorationarchives.model.Article;
import com.chiemy.demo.decorationarchives.model.DecorationCategory;
import com.chiemy.demo.decorationarchives.ui.adaoter.ArticleListAdapter;
import com.chiemy.demo.decorationarchives.utils.ArticleManager;

import java.util.List;

import rx.functions.Action1;


/**
 * Created: chiemy
 * Date: 16/12/16
 * Description:
 */

public class ArticleListActivity extends RecyclerViewActivity<Article> {
    public static final String EXTRA_CATEGORY = "category";

    public static void start(Context context, DecorationCategory category) {
        Intent intent = new ArticleListActivity.IntentBuilder(context)
                .categoryId(category)
                .build();
        context.startActivity(intent);
    }

    private static class IntentBuilder {
        private Context mContext;
        private DecorationCategory mCategory;

        public IntentBuilder(Context context) {
            mContext = context;
        }

        public IntentBuilder categoryId(DecorationCategory category) {
            mCategory = category;
            return this;
        }

        public Intent build() {
            Intent intent = new Intent(mContext, ArticleListActivity.class);
            intent.putExtra(EXTRA_CATEGORY, mCategory);
            return intent;
        }
    }

    private ArticleListAdapter mAdapter;
    private String mCategoryId;
    private DecorationCategory mCategory;

    @Override
    protected BaseQuickAdapter<Article> getAdapter() {
        return mAdapter = new ArticleListAdapter();
    }

    @Override
    protected void initData() {
        mCategory = (DecorationCategory) getIntent().getSerializableExtra(EXTRA_CATEGORY);
        mCategoryId = mCategory.id;
        listRaw();
    }

    public void listRaw() {
        ArticleManager.getArticle(this, mCategoryId, new Action1<List<Article>>() {
            @Override
            public void call(List<Article> articles) {
                mAdapter.setNewData(articles);
            }
        });
    }

    @Override
    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        super.onItemClick(baseQuickAdapter, view, i);
        Article article = (Article) view.getTag();
        MarkdownFileActivity.start(this, article.name, article.path);
    }
}
