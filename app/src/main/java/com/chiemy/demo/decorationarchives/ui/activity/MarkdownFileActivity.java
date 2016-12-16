package com.chiemy.demo.decorationarchives.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.chiemy.demo.decorationarchives.R;
import com.mukesh.MarkdownView;

import static android.R.attr.label;


public class MarkdownFileActivity extends AppCompatActivity {
    private static final String EXTRA_LABEL = "label";
    private static final String EXTRA_MD_PATH = "md_path";

    public static void start(Context context, String title, String assetPath) {
        Intent intent = new Intent(context, MarkdownFileActivity.class);
        intent.putExtra(EXTRA_LABEL, label);
        intent.putExtra(EXTRA_MD_PATH, assetPath);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_markdown_file);
        setTitle(getIntent().getStringExtra(EXTRA_LABEL));

        MarkdownView markdownView = (MarkdownView) findViewById(R.id.markdown_view);
        markdownView.loadMarkdownFromAssets(getIntent().getStringExtra(EXTRA_MD_PATH));
    }
}
