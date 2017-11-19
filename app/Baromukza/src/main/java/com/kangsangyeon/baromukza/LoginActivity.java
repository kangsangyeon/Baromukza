package com.kangsangyeon.baromukza;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.kangsangyeon.baromukza.item.MemberInfoItem;
import com.kangsangyeon.baromukza.lib.MySnack;
import com.kangsangyeon.baromukza.lib.MyToast;
import com.kangsangyeon.baromukza.remote.RemoteService;
import com.kangsangyeon.baromukza.remote.ServiceGenerator;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by pc-1 on 2017-11-18.
 */

public class LoginActivity extends AppCompatActivity {

	@BindView(R.id.login_id)
	EditText idEdit;
	@BindView(R.id.login_password)
	EditText passwordEdit;

	@OnClick(R.id.login_login_btn)
	public void onClickLogin(final View view){
		String id = idEdit.getText().toString();
		String password = passwordEdit.getText().toString();

		RemoteService remoteService = ServiceGenerator.createService(RemoteService.class);
		Call<MemberInfoItem> call = remoteService.selectMemberInfo(id, password);
		call.enqueue(new Callback<MemberInfoItem>() {
			@Override
			public void onResponse(Call<MemberInfoItem> call, Response<MemberInfoItem> response) {
				MemberInfoItem item = response.body();

				if(response.isSuccessful()){
					MyToast.l(LoginActivity.this, item.toString());
					((MyApp)getApplication()).CurrentMemberInfo = item;

					setResult(Activity.RESULT_OK);
					finish();
				}

			}

			@Override
			public void onFailure(Call<MemberInfoItem> call, Throwable t) {
				MySnack.show(view, "No Internet Connectivity");
				t.printStackTrace();
			}
		});
	}

	@OnClick(R.id.login_find_idpass)
	public void onClickFindIdpass(final View view){

	}

	@OnClick(R.id.login_join_member)
	public void onClickJoin(final View view){

	}

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		ButterKnife.bind(this, this);
	}

}