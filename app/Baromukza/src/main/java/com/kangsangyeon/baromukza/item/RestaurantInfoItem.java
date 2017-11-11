package com.kangsangyeon.baromukza.item;

import com.google.gson.annotations.SerializedName;

/**
 * Created by pc-1 on 2017-11-10.
 */

public class RestaurantInfoItem {

    @SerializedName("restaurant")           public int seq;
    @SerializedName("owner_seq")            public int ownerSeq;
    @SerializedName("name")                 public String name;
    @SerializedName("description")          public String description;
    @SerializedName("image")                public String image;
    @SerializedName("category_seq")         public int categorySeq;
    @SerializedName("start_time")           public String startTime;
    @SerializedName("end_time")             public String endTime;
    @SerializedName("rating")               public int rating;
    @SerializedName("phone")                public String phone;
    @SerializedName("address_1")            public String address1;
    @SerializedName("address_2")            public String address2;
    @SerializedName("address_3")            public String address3;

    @Override
    public String toString() {
        return "RestaurantInfoItem{" +
                "seq=" + seq +
                ", ownerSeq=" + ownerSeq +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", categorySeq=" + categorySeq +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", rating=" + rating +
                ", phone='" + phone + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", address3='" + address3 + '\'' +
                '}';
    }
}
