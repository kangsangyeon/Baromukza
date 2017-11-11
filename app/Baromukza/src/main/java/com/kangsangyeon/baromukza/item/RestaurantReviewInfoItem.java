package com.kangsangyeon.baromukza.item;

import com.google.gson.annotations.SerializedName;

/**
 * Created by pc-1 on 2017-11-10.
 */

public class RestaurantReviewInfoItem {
    @SerializedName("review_seq")           public int seq;
    @SerializedName("restaurant_seq")       public int restaurant_seq;
    @SerializedName("member_seq")           public int member_seq;
    @SerializedName("type")                 public String type;
    @SerializedName("rating")               public int rating;
    @SerializedName("title")                public String title;
    @SerializedName("content")              public String content;
    @SerializedName("reg_time")             public String regTime;

    @Override
    public String toString() {
        return "RestaurantReviewInfoItem{" +
                "seq=" + seq +
                ", restaurant_seq=" + restaurant_seq +
                ", member_seq=" + member_seq +
                ", type='" + type + '\'' +
                ", rating=" + rating +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", regTime='" + regTime + '\'' +
                '}';
    }
}
