package com.kangsangyeon.baromukza.item;

import com.google.gson.annotations.SerializedName;

/**
 * Created by pc-1 on 2017-11-10.
 */

public class RestaurantMenuInfoItem {
    @SerializedName("menu_seq")             public int seq;
    @SerializedName("restaurant_seq")       public int restaurantSeq;
    @SerializedName("name")                 public String name;
    @SerializedName("image")                public String image;
    @SerializedName("price")                public int price;

    @Override
    public String toString() {
        return "RestaurantMenuInfoItem{" +
                "seq=" + seq +
                ", restaurantSeq=" + restaurantSeq +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                '}';
    }
}
