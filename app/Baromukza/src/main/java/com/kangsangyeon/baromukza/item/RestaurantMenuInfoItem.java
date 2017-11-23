package com.kangsangyeon.baromukza.item;

import com.google.gson.annotations.SerializedName;
import com.kangsangyeon.baromukza.item.recycler.Item1ViewFieldInfoItem;
import com.kangsangyeon.baromukza.item.recycler.Item1Viewable;

/**
 * Created by pc-1 on 2017-11-10.
 */

public class RestaurantMenuInfoItem implements Item1Viewable{
    @SerializedName("menu_seq")             public int seq;
    @SerializedName("restaurant_seq")       public int restaurantSeq;
    @SerializedName("name")                 public String name;
    @SerializedName("image")                public String image;
    @SerializedName("price")                public int price;

    @Override
    public Item1ViewFieldInfoItem getViewFieldInfoItem() {
        return new Item1ViewFieldInfoItem(image, name, price + "원");
    }

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
