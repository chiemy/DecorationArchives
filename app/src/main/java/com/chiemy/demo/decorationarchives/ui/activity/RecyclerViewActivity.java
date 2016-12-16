package com.chiemy.demo.decorationarchives.ui.activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.SimpleClickListener;
import com.chiemy.demo.decorationarchives.R;

/**
 * Created: chiemy
 * Date: 16/11/24
 * Description:
 */

public abstract class RecyclerViewActivity<T> extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        initView();
        initData();
    }

    @LayoutRes
    protected int getLayoutId(){
        return R.layout.activity_recyclerview;
    }

    protected void initView() {
        RecyclerView recyclerView = getRecyclerView();
        recyclerView.setLayoutManager(getLayoutManager());
        recyclerView.addOnItemTouchListener(new SimpleClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                RecyclerViewActivity.this.onItemClick(baseQuickAdapter, view, i);
            }

            @Override
            public void onItemLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                RecyclerViewActivity.this.onItemLongClick(baseQuickAdapter, view, i);
            }

            @Override
            public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                RecyclerViewActivity.this.onItemChildClick(baseQuickAdapter, view, i);
            }

            @Override
            public void onItemChildLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                RecyclerViewActivity.this.onItemChildLongClick(baseQuickAdapter, view, i);
            }
        });
        BaseQuickAdapter<T> adapter = getAdapter();
        recyclerView.setAdapter(adapter);
    }

    protected RecyclerView getRecyclerView() {
        return (RecyclerView) findViewById(R.id.recycler_view);
    }

    protected RecyclerView.LayoutManager getLayoutManager() {
        return new LinearLayoutManager(this);
    }

    protected abstract BaseQuickAdapter<T> getAdapter();

    protected abstract void initData();

    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
    }

    public void onItemLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
    }

    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
    }

    public void onItemChildLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
    }
}
