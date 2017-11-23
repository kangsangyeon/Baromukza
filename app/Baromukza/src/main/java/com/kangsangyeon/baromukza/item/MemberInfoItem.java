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

	public MemberInfoItem(){}
	private MemberInfoItem(int seq, String id, String password, String name, String birth, String gender, String phone, String image, String email, String joinDate) {
		this.seq = seq;
		this.id = id;
		this.password = password;
		this.name = name;
		this.birth = birth;
		this.gender = gender;
		this.phone = phone;
		this.image = image;
		this.email = email;
		this.joinDate = joinDate;
	}

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

    public MemberInfoItem clone(){

		return new MemberInfoItem(this.seq, this.id, this.password, this.name, this.birth, this.gender, this.phone, this.image, this.email, this.joinDate);
	}
}
