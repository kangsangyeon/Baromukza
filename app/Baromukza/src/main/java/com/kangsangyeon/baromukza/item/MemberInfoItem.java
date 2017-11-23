package com.kangsangyeon.baromukza.item;

import com.google.gson.annotations.SerializedName;

/**
 * Created by pc-1 on 2017-11-07.
 */

public class MemberInfoItem {

    @SerializedName("member_seq")           public int seq;
    @SerializedName("id")                   public String id;
    @SerializedName("password")             public String password;
    @SerializedName("name")                 public String name;
    @SerializedName("birth")                public String birth;
    @SerializedName("gender")               public String gender;
    @SerializedName("phone")                public String phone;
    @SerializedName("image")                public String image;
    @SerializedName("email")                public String email;
    @SerializedName("join_date")            public String joinDate;

    @Override
    public String toString() {
        return "MemberInfoItem{" +
                "seq=" + seq +
                ", id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", birth='" + birth + '\'' +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", image='" + image + '\'' +
                ", email='" + email + '\'' +
                ", joinDate='" + joinDate + '\'' +
                '}';
    }
}
