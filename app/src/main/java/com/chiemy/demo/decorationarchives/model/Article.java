package com.chiemy.demo.decorationarchives.model;

/**
 * Created: chiemy
 * Date: 16/12/16
 * Description:
 */

public class Article {
    public String id;
    public String name;
    public String author;
    public String path;
    public String summary;
    public String image;

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", path='" + path + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
