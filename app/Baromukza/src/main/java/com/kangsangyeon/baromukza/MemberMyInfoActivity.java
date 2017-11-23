package com.kangsangyeon.baromukza;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.kangsangyeon.baromukza.item.MemberInfoItem;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
    public void onChangeBirth(View view) {

    }

    @OnClick(R.id.myinfo_apply)
    public void onClickApply(View view) {
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

		MemberInfoItem newMemberInfoItem = new MemberInfoItem();
		newMemberInfoItem.name = name;
		newMemberInfoItem.birth = birth;
		newMemberInfoItem.gender = gender;
		newMemberInfoItem.phone = phone;
		newMemberInfoItem.email = email;
		Toast.makeText(MemberMyInfoActivity.this, newMemberInfoItem.toString(), Toast.LENGTH_SHORT).show();
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