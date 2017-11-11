package com.kangsangyeon.baromukza.item;

import com.google.gson.annotations.SerializedName;

/**
 * Created by pc-1 on 2017-11-10.
 */

public class RestaurantCategoryInfoItem {

    @SerializedName("category_seq")         public int seq;
    @SerializedName("name")                 public String name;

    @Override
    public String toString() {
        return "RestaurantCategoryInfoItem{" +
                "seq=" + seq +
                ", name='" + name + '\'' +
                '}';
    }
}
