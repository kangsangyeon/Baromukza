package com.kangsangyeon.baromukza;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.kangsangyeon.baromukza.lib.MySnack;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by pc-1 on 2017-11-10.
 */

public class MyPageActivity extends AppCompatActivity {

    @OnClick(R.id.mypage_profile_setting_image)
    public void onClickProfileSettingImage(final View view){

    }
    @OnClick(R.id.mypage_myinfo)
    public void onClickMyInfo(final View view){
        MySnack.show(view, "MyInfo");
        Intent intent = new Intent(MyPageActivity.this, MyInfoActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.mypage_favorite)
    public void onClickFavorite(final View view){
        MySnack.show(view, "Favorite");
    }

    @OnClick(R.id.mypage_reserves)
    public void onClickReserves(final View view){
        MySnack.show(view, "Reserves");
    }

    @OnClick(R.id.mypage_reservation_list)
    public void onClickReservationList(final View view){
        MySnack.show(view, "ReservationList");
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        ButterKnife.bind(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

}