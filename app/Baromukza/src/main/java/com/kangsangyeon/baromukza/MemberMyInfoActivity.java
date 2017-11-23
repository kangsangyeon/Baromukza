package com.kangsangyeon.baromukza;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.kangsangyeon.baromukza.item.MemberInfoItem;
import com.kangsangyeon.baromukza.lib.MySnack;
import com.kangsangyeon.baromukza.remote.RemoteService;
import com.kangsangyeon.baromukza.remote.ServiceGenerator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by pc-1 on 2017-11-10.
 */

public class MemberMyInfoActivity extends AppCompatActivity {

	@BindView(R.id.toolbar)
	Toolbar toolbar;

    @BindView(R.id.myinfo_name)
    EditText nameEdit;
    @BindView(R.id.myinfo_birth)
    TextView birthText;
    @BindView(R.id.myinfo_gender_group)
    RadioGroup genderGroupRadio;
    @BindView(R.id.myinfo_gender_man)
    RadioButton genderManButton;
    @BindView(R.id.myinfo_gender_woman)
    RadioButton genderWomanButton;
    @BindViews({R.id.myinfo_phone_1, R.id.myinfo_phone_2, R.id.myinfo_phone_3})
    List<EditText> phoneEditList;
    @BindView(R.id.myinfo_email)
    EditText emailEdit;

    @OnClick(R.id.myinfo_birth_change)
    public void onChangeBirth(final View view) {

    }

    @OnClick(R.id.myinfo_apply)
    public void onClickApply(final View view) {
        String name = nameEdit.getText().toString();

        String birth = birthText.getText().toString();

        String gender = null;
        if (genderGroupRadio.getCheckedRadioButtonId() == R.id.myinfo_gender_man) {
            gender = "m";
        } else if (genderGroupRadio.getCheckedRadioButtonId() == R.id.myinfo_gender_woman) {
            gender = "w";
        }

        String phone = "%s-%s-%s";
		phone = String.format(phone,
				phoneEditList.get(0).getText().toString(),
				phoneEditList.get(1).getText().toString(),
				phoneEditList.get(2).getText().toString()
		);

        String email = emailEdit.getText().toString();

		MemberInfoItem currentMemberInfoItem = ((MyApp) getApplication()).CurrentMemberInfo;
		MemberInfoItem newMemberInfoItem = currentMemberInfoItem.clone();
		newMemberInfoItem.name = name;
		newMemberInfoItem.birth = birth;
		newMemberInfoItem.gender = gender;
		newMemberInfoItem.phone = phone;
		newMemberInfoItem.email = email;
//		MyToast.l(MemberMyInfoActivity.this, newMemberInfoItem.toString());

		RemoteService remoteService = ServiceGenerator.createService(RemoteService.class);
		Call<String> call = remoteService.putMemberInfo(newMemberInfoItem.id, newMemberInfoItem);
		call.enqueue(new Callback<String>() {
			@Override
			public void onResponse(Call<String> call, Response<String> response) {

				if(response.isSuccessful()){

					setResult(Activity.RESULT_OK);
					finish();
				}
				else{
					MySnack.show(view, getString(R.string.myinfo_error));
				}

			}

			@Override
			public void onFailure(Call<String> call, Throwable t) {
				MySnack.show(view, getString(R.string.error_internet));
				t.printStackTrace();
			}
		});
	}

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myinfo);

        ButterKnife.bind(this);

		toolbar.setTitle(getString(R.string.title_myinfo));

        MemberInfoItem memberInfoItem = ((MyApp) getApplication()).CurrentMemberInfo;
        setView(memberInfoItem);
    }

    /**
     * 뷰들의 내용을 사용자 정보로 초기화하는 메소드이다.
     *
     * @param memberInfoItem 사용자 정보 객체
     */
    private void setView(MemberInfoItem memberInfoItem) {
        nameEdit.setText(memberInfoItem.name);

		Pattern p = Pattern.compile("^(\\d{4}-\\d{2}-\\d{2})");
		Matcher m = p.matcher(memberInfoItem.birth);
		if(m.find()){
			birthText.setText(m.group());
		}
		birthText.setText(memberInfoItem.birth);

        if (memberInfoItem.gender.equals("m")) {
            genderManButton.setChecked(true);
            genderWomanButton.setChecked(false);
        } else if (memberInfoItem.gender.equals("w")) {
            genderManButton.setChecked(false);
            genderWomanButton.setChecked(true);
        }

        String[] phoneArr = memberInfoItem.phone.split("-");
        for (int i = 0; i < phoneArr.length; i++) {
            phoneEditList.get(i).setText(phoneArr[i]);
        }

        emailEdit.setText(memberInfoItem.email);
    }


}