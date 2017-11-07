package com.kangsangyeon.baromukza.remote;


import com.kangsangyeon.baromukza.item.MemberInfoItem;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

// 모모 앱플레이어 DB 정보 입력 스크립트
// INSERT INTO member(phone, name) VALUE('01865166029343863', 'MOMO APPPLAYER');

/**
 * 서버에 호출할 메소드를 선언하는 인터페이스
 */
public interface RemoteService {
    String BASE_URL = "http://192.168.1.2:3000";
    String MEMBER_ICON_URL = BASE_URL + "/member/";
    String IMAGE_URL = BASE_URL + "/img/";

    /**
     * 서버로부터 사용자 정보 반환을 요청하기
     * @param phone 폰 전화번호
     * @return 사용자 정보
     */
    @GET("/member/{phone}")
    Call<MemberInfoItem> selectMemberInfo(@Path("phone") String phone);

    /**
     * 서버에 사용자 정보 등록 요청하기
     * @param phone 폰 전화번호
     * @return 결과 String
     */
    @FormUrlEncoded
    @POST("/member/phone")
    Call<String> insertMemberPhone(@Field("phone") String phone);

    /**
     * 서버에 사용자 정보 수정하기
     * @param memberInfoItem
     * @return
     */
    @POST("/member/info")
    Call<String> insertMemberInfo(@Body MemberInfoItem memberInfoItem);
}