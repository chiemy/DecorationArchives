package com.chiemy.demo.decorationarchives.ui.activity;

import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chiemy.demo.decorationarchives.R;
import com.chiemy.demo.decorationarchives.model.DecorationCategory;
import com.chiemy.demo.decorationarchives.ui.adaoter.DecorationCategoryAdapter;
import com.chiemy.demo.decorationarchives.ui.widget.CommonGridItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends RecyclerViewActivity<DecorationCategory> {
    private DecorationCategoryAdapter mAdapter;

    @Override
    protected DecorationCategoryAdapter getAdapter() {
        return mAdapter = new DecorationCategoryAdapter();
    }

    @Override
    protected RecyclerView.LayoutManager getLayoutManager() {
        return new GridLayoutManager(this, 2);
    }

    @Override
    protected void initData() {
        getRecyclerView().setBackgroundColor(Color.parseColor("#cccccc"));
        getRecyclerView().addItemDecoration(new CommonGridItemDecoration(2, 0, 2, 2));

        String [] names = getResources().getStringArray(R.array.category_names);
        String [] ids = getResources().getStringArray(R.array.category_ids);

        List<DecorationCategory> categories = new ArrayList<>(names.length);
        for (int i = 0; i < names.length; i++) {
            categories.add(new DecorationCategory(ids[i], names[i]));
        }
        mAdapter.setNewData(categories);
    }

    @Override
    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        super.onItemClick(baseQuickAdapter, view, i);
        DecorationCategory category = (DecorationCategory) view.getTag();
        ArticleListActivity.start(this, category);
    }
}
