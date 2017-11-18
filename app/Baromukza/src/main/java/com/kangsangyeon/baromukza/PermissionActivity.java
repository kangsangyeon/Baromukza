package com.kangsangyeon.baromukza;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.kangsangyeon.baromukza.lib.MySnack;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.picasso.transformations.BlurTransformation;

/**
 * 앱을 실행할 때 필됴한 권한을 처리하기 위한 액티비티
 */
public class PermissionActivity extends AppCompatActivity {

	private Context mContext;
	private View mView;

	@BindView(R.id.permission_bgimage)
	ImageView backgroundImage;


	private static final int PERMISSION_MULTI_CODE = 100;

	/**
	 * 화면을 구성하고 멤버변수 mContext와 mView를 초기화한다.
	 *
	 * @param savedInstanceState 액티비티가 새로 생성되었을 경우, 이전 상태 값을 가지는 객체
	 */
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mContext = this;
		mView = getLayoutInflater().from(this).inflate(R.layout.activity_permission, null);
		setContentView(mView);

		ButterKnife.bind(this, this);
	}

	/**
	 * 배경화면을 임의의 배경으로 바꾸고
	 * 일정 시간(2초) 이후에 필요한 권한을 검사한다.
	 * SDK 버젼이 23 미만인 경우에는 필요 권한을 Menifest에만 작성해두면 되었지만
	 * SDK 버젼이 23 이상인 경우에는 사용자로부터 권한을 승인받아야 하는 방식이다.
	 */
	@Override
	protected void onStart() {
		super.onStart();

		setBackgroundImage();

		// 2초 뒤 권한 검사
		Handler mHandler = new Handler();
		mHandler.postDelayed(new Runnable() {
			@Override
			public void run() {
				if (Build.VERSION.SDK_INT < 23) {
					// Main Page 로 바로 이동
					goMainActivity();
				} else {
					// 권한 체크 후 Main Page 이동
					if (checkAndRequestPermissions()) {
						goMainActivity();
					}
				}
			}
		}, 2000);
	}

	private void setBackgroundImage(){
		int[] bgImageArr = new int[]{R.drawable.restaurant_1, R.drawable.restaurant_2, R.drawable.restaurant_3, R.drawable.restaurant_4};
		int randomIndex = new Random().nextInt(bgImageArr.length);
		Picasso.with(this)
				.load(bgImageArr[randomIndex])
				.transform(new BlurTransformation(this, 3, 3))
				.into(backgroundImage);
	}

	/**
	 * 권한을 확인하고 권한이 부여되어 있지 않다면 권한을 요청한다.
	 *
	 * @return 필요한 권한이 모두 부여되었다면 true, 그렇지 않다면 false
	 */
	private boolean checkAndRequestPermissions() {

		String[] permissions = new String[]{
				Manifest.permission.READ_PHONE_STATE,
				Manifest.permission.ACCESS_FINE_LOCATION
		};

		List<String> listPermissionsNeeded = new ArrayList<>();

		for (String permission : permissions) {
			if (ContextCompat.checkSelfPermission(PermissionActivity.this, permission) != PackageManager.PERMISSION_GRANTED) {
				listPermissionsNeeded.add(permission);
			}
		}

		if (!listPermissionsNeeded.isEmpty()) {
			ActivityCompat.requestPermissions(PermissionActivity.this,
					listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]),
					PERMISSION_MULTI_CODE);
			return false;
		}

		return true;
	}

	/**
	 * 권한 요청 결과를 받는 메소드
	 *
	 * @param requestCode  요청 코드
	 * @param permissions  권한 종류
	 * @param grantResults 권한 결과
	 */
	@Override
	public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

		if (grantResults.length == 0) return;

		switch (requestCode) {
			case PERMISSION_MULTI_CODE:
				checkPermissionResult(permissions, grantResults);
				break;
		}
	}

	/**
	 * 권한 처리 결과를 보고 인덱스 액티비티를 실행할지,
	 * 권한 설정 요청 다이얼로그를 보여줄지 결정한다.
	 * 모든 권한이 승인되었을 경우에는 goMainActivity() 메소드를 호출한다.
	 *
	 * @param permissions  권한 종류
	 * @param grantResults 권한 부여 결과
	 */
	private void checkPermissionResult(String[] permissions, int[] grantResults) {
		boolean isAllGranted = true;

		for (int i = 0; i < permissions.length; i++) {
			if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
				isAllGranted = false;
				break;
			}
		}

		if (isAllGranted) {
			// 권한이 부여되었다면 index page로 이동
			goMainActivity();
		} else {
			// 권한이 부여되어 있지 않다면
			showPermissionDialog();
		}

	}

	/**
	 * 인덱스 액티비티를 실행하고 현재 액티비티를 종료한다.
	 */
	private void goMainActivity() {
		Intent intent = new Intent(PermissionActivity.this, MainActivity.class);
		startActivity(intent);

		finish();
	}

	/**
	 * 권한 설정 화면으로 이동할지를 선택하는 다이얼로그를 보여준다.
	 */
	private void showPermissionDialog() {
		AlertDialog.Builder builder = new AlertDialog.Builder(PermissionActivity.this);
		builder.setTitle("권한 설정")
				.setMessage("앱 작동을 위한 권한 설정이 필요합니다!")
				.setPositiveButton("설정", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialogInterface, int i) {
						dialogInterface.cancel();
						MySnack.show(mView, "권한을 설정한 뒤 앱을 재실행해주세요");

						PermissionActivity.this.finish();

						goAppSettingActivity();
					}
				})
				.setNegativeButton("취소", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialogInterface, int i) {
						dialogInterface.cancel();
						PermissionActivity.this.finish();
					}
				})
				.show();
	}

	/**
	 * 권한을 설정할 수 있는 설정 액티비티를 실행한다.
	 */
	private void goAppSettingActivity() {
		Intent intent = new Intent();
		intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
		Uri uri = Uri.fromParts("package", getPackageName(), null);
		intent.setData(uri);
		startActivity(intent);
	}
}
