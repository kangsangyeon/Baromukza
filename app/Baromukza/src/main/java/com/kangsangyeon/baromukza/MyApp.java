package com.kangsangyeon.baromukza;

import android.app.Application;

import com.kangsangyeon.baromukza.item.MemberInfoItem;
import com.kangsangyeon.baromukza.item.OwnerInfoItem;

/**
 * Created by pc-1 on 2017-11-10.
 */

public class MyApp extends Application {

    public MemberInfoItem CurrentMemberInfo;
	public OwnerInfoItem CurrentOwnerInfo;

	/**
	 * 로그인이 되어있는 여부를 반환하는 메소드.
	 * 회원정보나 점장 정보가 null이 아닌경우 true
	 * @return 로그인 여부
	 */
	public boolean isLoggedIn(){
		if(CurrentMemberInfo != null || CurrentOwnerInfo != null){
			return true;
		}
		else{
			return false;
		}
	}

}