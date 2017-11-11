package com.kangsangyeon.baromukza.remote;


import com.kangsangyeon.baromukza.item.MemberInfoItem;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

// 모모 앱플레이어 DB 정보 입력 스크립트
// INSERT INTO member(phone, name) VALUE('01865166029343863', 'MOMO APPPLAYER');

/**
 * 서버에 호출할 메소드를 선언하는 인터페이스
 */
public interface RemoteService {
    String BASE_URL = "http://192.168.1.2:3000";

    /**
     * 서버로부터 멤버 정보 얻어오기
     * @param id 사용자 ID
     * @param password 사용자 Password
     * @return 멤버 정보 객체
     */
    @FormUrlEncoded
    @POST("/member/{id}")
    Call<MemberInfoItem> selectMemberInfo(@Path("id") String id,
                                          @Field("password") String password);

    @POST("/member/")
    Call<String> insertMemberInfo(@Body MemberInfoItem memberInfoItem);
}