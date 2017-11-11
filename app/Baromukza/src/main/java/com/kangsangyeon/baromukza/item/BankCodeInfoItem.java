package com.kangsangyeon.baromukza.item;

import com.google.gson.annotations.SerializedName;

/**
 * Created by pc-1 on 2017-11-10.
 */

public class BankCodeInfoItem {
    @SerializedName("bank_seq")             public int seq;
    @SerializedName("name")                 public String name;

    @Override
    public String toString() {
        return "BankCodeInfoItem{" +
                "seq=" + seq +
                ", name='" + name + '\'' +
                '}';
    }
}
