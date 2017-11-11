package com.kangsangyeon.baromukza.item;

import com.google.gson.annotations.SerializedName;

/**
 * Created by pc-1 on 2017-11-10.
 */

public class ReservationInfoItem {

    @SerializedName("reservation_seq")      public int seq;
    @SerializedName("member_seq")           public int member_seq;
    @SerializedName("restaurant_seq")       public int restaurant_seq;
    @SerializedName("reservated_time")      public String reservatedTime;
    @SerializedName("is_accepted")          public String isAccepted;
    @SerializedName("reservation_time")     public String reservationTime;
    @SerializedName("member_count")         public int memberCount;
    @SerializedName("reserves")             public int reserves;

    @Override
    public String toString() {
        return "ReservationInfoItem{" +
                "seq=" + seq +
                ", member_seq=" + member_seq +
                ", restaurant_seq=" + restaurant_seq +
                ", reservatedTime='" + reservatedTime + '\'' +
                ", isAccepted='" + isAccepted + '\'' +
                ", reservationTime='" + reservationTime + '\'' +
                ", memberCount=" + memberCount +
                ", reserves=" + reserves +
                '}';
    }
}
