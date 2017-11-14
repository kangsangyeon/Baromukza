package com.kangsangyeon.baromukza.remote;


import com.kangsangyeon.baromukza.item.MemberInfoItem;
import com.kangsangyeon.baromukza.item.OwnerInfoItem;
import com.kangsangyeon.baromukza.item.RestaurantInfoItem;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

// 모모 앱플레이어 DB 정보 입력 스크립트
// INSERT INTO member(phone, name) VALUE('01865166029343863', 'MOMO APPPLAYER');

/**
 * 서버에 호출할 메소드를 선언하는 인터페이스
 */
public interface RemoteService {
    String BASE_URL = "http://192.168.55.246:3000";

    /**
     * 멤버 정보 얻어오기
     * @param id 사용자 ID
     * @param password 사용자 Password
     * @return 멤버 정보 객체
     */
    @FormUrlEncoded
    @POST("/member/{id}")
    Call<MemberInfoItem> selectMemberInfo(@Path("id") String id,
                                          @Field("password") String password);

    /**
     * 신규 멤버 정보 등록하기
     * @param memberInfoItem
     * @return 결과 json string
     */
    @POST("/member/")
    Call<String> insertMemberInfo(@Body MemberInfoItem memberInfoItem);

    /**
     * 멤버 정보 수정
     * @param id 수정할 멤버의 id
     * @param memberInfoItem 수정할 멤버의 정보 객체
     * @return 결과 json string
     */
    @PUT("/member/{id}")
    Call<String> putMemberInfo(@Path("id") String id,
                               @Body MemberInfoItem memberInfoItem);

    /**
     * 멤버 정보 삭제
     * @param id 삭제할 멤버의 id
     * @param password 삭제할 멤버의 Password
     * @return 결과 json string
     */
    @FormUrlEncoded
    @DELETE("/member/")
    Call<String> deleteMemberInfo(@Field("id") String id,
                                  @Field("password") String password);



    /**
     * 점장 정보 얻어오기
     * @param id 사용자 ID
     * @param password 사용자 Password
     * @return 점장 정보 객체
     */
    @FormUrlEncoded
    @POST("/owner/{id}")
    Call<OwnerInfoItem> selectOwnerInfo(@Path("id") String id,
										@Field("password") String password);

    /**
     * 신규 점장 정보 등록하기
     * @param ownerInfoItem
     * @return 결과 json string
     */
    @POST("/owner/")
    Call<String> insertOwnerInfo(@Body OwnerInfoItem ownerInfoItem);

    /**
     * 점장 정보 수정
     * @param id 수정할 점장의 id
     * @param memberInfoItem 수정할 점장의 정보 객체
     * @return 결과 json string
     */
    @PUT("/owner/{id}")
    Call<String> putOwnerInfo(@Path("id") String id,
                               @Body OwnerInfoItem memberInfoItem);

    /**
     * 점장 정보 삭제
     * @param id 삭제할 점장의 id
     * @param password 삭제할 점장의 Password
     * @return 결과 json string
     */
    @FormUrlEncoded
    @DELETE("/owner/")
    Call<String> deleteOwnerInfo(@Field("id") String id,
                                  @Field("password") String password);


	// 매장
	/**
	 * 매장 정보 얻어오기
	 * @param restaurantSeq 매장 seq
	 * @return 멤버 정보 객체
	 */
	@POST("/restaurant/{restaurant_seq}")
	Call<OwnerInfoItem> selectRestaurantInfo(@Path("restaurant_seq") String restaurantSeq);

	/**
	 * 신규 매장 정보 등록하기
	 * @param restaurantInfoItem 레스토랑 정보
	 * @return 결과 json string
	 */
	@POST("/restaurant/")
	Call<String> insertRestaurantInfo(@Body RestaurantInfoItem restaurantInfoItem);

	/**
	 * 매장 정보 수정
	 * @param restaurantSeq 수정할 매장의 seq
	 * @param restaurantInfoItem 수정할 매장의 정보 객체
	 * @return 결과 json string
	 */
	@PUT("/restaurant/{restaurant_seq}")
	Call<String> putRestaurantInfo(@Path("restaurant_seq") String restaurantSeq,
							  @Body RestaurantInfoItem restaurantInfoItem);

	/**
	 * 매장 정보 삭제
	 * @param owner_seq 삭제할 매장의 점장 seq
	 * @param restaurant_seq 삭제할 매장의 seq
	 * @return 결과 json string
	 */
	@FormUrlEncoded
	@DELETE("/restaurant/")
	Call<String> deleteRestaurantInfo(@Field("owner_seq") String owner_seq,
								 @Field("restaurant_seq") String restaurant_seq);


    /**
     * 전체 레스토랑 정보 리스트 얻어오기
     * @return 전체 레스토랑 정보 ArrayList
     */
    @GET("/restaurant/list")
    Call<ArrayList<RestaurantInfoItem>> selectRestaurantInfoList();

}