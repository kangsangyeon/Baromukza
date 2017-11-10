package com.kangsangyeon.baromukza.item;

import com.google.gson.annotations.SerializedName;

/**
 * Created by pc-1 on 2017-11-10.
 */

public class ReservationDetailInfoItem {

    @SerializedName("reservation_detail_seq")       public int seq;
    @SerializedName("reservation_seq")              public int reservationSeq;
    @SerializedName("menu_seq")                     public int menuSeq;
    @SerializedName("count")                        public int count;
    @SerializedName("price")                        public int price;
    
}
