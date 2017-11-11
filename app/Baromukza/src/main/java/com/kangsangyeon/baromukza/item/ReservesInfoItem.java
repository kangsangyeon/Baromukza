package com.kangsangyeon.baromukza.item;

import com.google.gson.annotations.SerializedName;

/**
 * Created by pc-1 on 2017-11-10.
 */

public class ReservesInfoItem {

    @SerializedName("member_seq")           public int seq;
    @SerializedName("restaurant_seq")       public int restaurant_seq;
    @SerializedName("reserves")             public int reserves;
    @SerializedName("last_modified_date")   public String lastModifiedDate;

    @Override
    public String toString() {
        return "ReservesInfoItem{" +
                "seq=" + seq +
                ", restaurant_seq=" + restaurant_seq +
                ", reserves=" + reserves +
                ", lastModifiedDate='" + lastModifiedDate + '\'' +
                '}';
    }
}
