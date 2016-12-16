package com.chiemy.demo.decorationarchives.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.chiemy.demo.decorationarchives.model.Article;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created: chiemy
 * Date: 16/12/16
 * Description:
 */

public class ArticleManager {
    private static Map<String, List<Article>> mMap = new HashMap<>();
    private static final String REGEX = "\\|";
    private static final String ARTICLES_FOLDER = "articles";
    private static final String MD_SUFFIXES = ".md";

    public static void getArticle(Context context, final String categoryId, final Action1<List<Article>> action1) {
        if (mMap.get(categoryId) != null) {
            action1.call(mMap.get(categoryId));
            return;
        }
        String [] filesName = null;
        try {
            filesName = context.getAssets().list(ARTICLES_FOLDER);
        } catch (IOException e) {
            e.printStackTrace();
        }
        final List<Article> articles = new ArrayList<>();
        Observable
                .from(filesName)
                .map(new Func1<String, String[]>() {
                    @Override
                    public String[] call(String string) {
                        String[] arr = getSplitArr(string);
                        return arr;
                    }
                })
                .filter(new Func1<String[], Boolean>() {
                    @Override
                    public Boolean call(String[] arr) {
                        return TextUtils.equals(categoryId, arr[0]);
                    }
                })
                .map(new Func1<String[], Article>() {
                    @Override
                    public Article call(String[] arr) {
                        String path = String.format(ARTICLES_FOLDER + "/%s|%s", arr[0], arr[1]);
                        Article article = new Article();
                        article.id = arr[0];
                        article.name = arr[1].replace(MD_SUFFIXES, "");
                        article.path = path;
                        return article;
                    }
                })
                .subscribeOn(Schedulers.computation())
                .doOnNext(new Action1<Article>() {
                    @Override
                    public void call(Article article) {
                        articles.add(article);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .doOnCompleted(new Action0() {
                    @Override
                    public void call() {
                        mMap.put(categoryId, articles);
                        action1.call(articles);
                    }
                })
                .subscribe();
    }

    @NonNull
    private static String[] getSplitArr(String string) {
        return string.split(REGEX);
    }
}
