package com.kangsangyeon.baromukza;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.kangsangyeon.baromukza.adapter.MainViewPagerAdapter;
import com.kangsangyeon.baromukza.item.MemberInfoItem;
import com.kangsangyeon.baromukza.item.OwnerInfoItem;
import com.kangsangyeon.baromukza.lib.MyToast;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity
		implements NavigationView.OnNavigationItemSelectedListener {

	@BindView(R.id.toolbar)
	Toolbar toolbar;
	@BindView(R.id.drawer_layout)
	DrawerLayout drawer;
	@BindView(R.id.nav_view)
	NavigationView navigationView;
	@BindView(R.id.main_tablayout)
	TabLayout tabLayout;
	@BindView(R.id.main_viewpager)
	ViewPager viewPager;


	MyApp mMyApp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ButterKnife.bind(this, this);

		// Application 객체 초기화
		mMyApp = (MyApp) getApplication();

		// Toolbar 설정
		setSupportActionBar(toolbar);

		// Drawer Layout 설정
		ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
				this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
		drawer.addDrawerListener(toggle);
		toggle.syncState();

		// Bind Navigation Layout Header's Child Views
		View navHeaderView = navigationView.getHeaderView(0);
		TextView headerName = (TextView)navHeaderView.findViewById(R.id.nav_header_name);
		CircleImageView headerProfileImage = (CircleImageView)navHeaderView.findViewById(R.id.nav_header_main_profile_image);
		TextView headerMyInfoButton = (TextView)navHeaderView.findViewById(R.id.nav_header_myinfo_button);

		// Navigation Menu 설정
		if (mMyApp.isLoggedIn() == true) {
			navigationView.inflateMenu(R.menu.main_drawer);
		}
		else {
			navigationView.inflateMenu(R.menu.main_drawer_need_login);
		}
		navigationView.setNavigationItemSelectedListener(this);

		// Tab Layout과 View Pager 설정
		MainViewPagerAdapter adapter = new MainViewPagerAdapter(getSupportFragmentManager());
		viewPager.setAdapter(adapter);
		tabLayout.setupWithViewPager(viewPager);

		// Navigation 의 상단 헤더 초기화
		// TODO: 이미지 리소스 뜨게 변경할 것
		headerMyInfoButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if(mMyApp.isLoggedIn() == true && mMyApp.getLoggedInAs() == UserType.MEMBER){
					Intent intent = new Intent(MainActivity.this, MemberMyInfoActivity.class);
					startActivity(intent);
				}
				else if(mMyApp.isLoggedIn() == true && mMyApp.getLoggedInAs() == UserType.OWNER){
//					Intent intent = new Intent(MainActivity.this, MemberMyInfoActivity.class);
//					startActivity(intent);
				}
				else{
					MyToast.s(MainActivity.this, getString(R.string.login_need));
					goLoginActivity();
				}

			}
		});
		if(mMyApp.isLoggedIn() == true && mMyApp.getLoggedInAs() == UserType.MEMBER){
			MemberInfoItem currentMemberInfo = mMyApp.CurrentMemberInfo;
			headerName.setText(currentMemberInfo.name);
//			headerProfileImage
		}
		else if(mMyApp.isLoggedIn() == true && mMyApp.getLoggedInAs() == UserType.OWNER){
			OwnerInfoItem currentOwnerInfo = mMyApp.CurrentOwnerInfo;
			headerName.setText(currentOwnerInfo.name);
		}
		else{
			headerName.setText(getString(R.string.login_need));
		}
	}

	@Override
	public void onBackPressed() {
		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		if (drawer.isDrawerOpen(GravityCompat.START)) {
			drawer.closeDrawer(GravityCompat.START);
		}
		else {
			super.onBackPressed();
		}
	}

	@SuppressWarnings("StatementWithEmptyBody")
	@Override
	public boolean onNavigationItemSelected(MenuItem item) {
		// Handle navigation view item clicks here.
		int id = item.getItemId();

		if (id == R.id.nav_main_login) {
			goLoginActivity();
		}
		else if (id == R.id.nav_main_mypage) {
			goMyPageActivity();
		}
		else if (id == R.id.nav_main_reserve_history) {

		}
		else if (id == R.id.nav_main_reserves) {

		}
		else if (id == R.id.nav_main_favorite) {

		}
		else if (id == R.id.nav_main_recent_seach) {

		}
		else if (id == R.id.nav_main_recent_reservation) {

		}
		else if (id == R.id.nav_main_recent_charge) {

		}

		drawer.closeDrawer(GravityCompat.START);
		return true;
	}

	private void goMyPageActivity() {
		Intent intent = new Intent(MainActivity.this, MyPageActivity.class);
		startActivity(intent);
	}

	private void goLoginActivity() {
		Intent intent = new Intent(MainActivity.this, LoginActivity.class);
		startActivityForResult(intent, Constant.REQUEST_LOGIN);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == Constant.REQUEST_LOGIN) {
			if (resultCode == Activity.RESULT_OK) {
				//로그인 성공
				refreshActivity();
			}
			else {
				// 로그인 취소
				MyToast.s(MainActivity.this, getString(R.string.login_cancel));
			}
		}
	}

	private void refreshActivity() {
		Intent intent = new Intent(MainActivity.this, MainActivity.class);
		startActivity(intent);
	}

}