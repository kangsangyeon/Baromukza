package com.kangsangyeon.baromukza.item;

import com.google.gson.annotations.SerializedName;

/**
 * Created by pc-1 on 2017-11-10.
 */

public class BankAccountInfoItem {

    @SerializedName("bank_account_seq")     public int seq;
    @SerializedName("bank_seq")             public int bankSeq;
    @SerializedName("account")              public String account;
}
