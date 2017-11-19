package com.kangsangyeon.baromukza.item;

import com.google.gson.annotations.SerializedName;

/**
 * Created by pc-1 on 2017-11-07.
 */

public class OwnerInfoItem {

    @SerializedName("owner_seq")            public int seq;
    @SerializedName("id")                   public String id;
    @SerializedName("password")             public String password;
    @SerializedName("name")                 public String name;
    @SerializedName("phone")                public String phone;
    @SerializedName("email")                public String email;
    @SerializedName("bank_account_seq")     public int bankAccountSeq;
    @SerializedName("join_date")            public String joinDate;

    @Override
    public String toString() {
        return "OwnerInfoItem{" +
                "seq=" + seq +
                ", id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", bankAccountSeq=" + bankAccountSeq +
                ", joinDate='" + joinDate + '\'' +
                '}';
    }
}
