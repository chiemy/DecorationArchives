package com.chiemy.demo.decorationarchives.model;

import java.io.Serializable;

/**
 * Created: chiemy
 * Date: 16/12/16
 * Description:
 */

public class DecorationCategory implements Serializable {
    public String id;
    public String name;
    public String imageUrl;

    public DecorationCategory(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
