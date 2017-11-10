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
}
