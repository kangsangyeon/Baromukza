package com.kangsangyeon.baromukza;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.kangsangyeon.baromukza.item.MemberInfoItem;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by pc-1 on 2017-11-10.
 */

public class MemberMyInfoActivity extends AppCompatActivity {

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
    @BindView(R.id.myinfo_bank_account)
    TextView bankAccountText;

    @OnClick(R.id.myinfo_birth_change)
    public void onChangeBirth(View view) {

    }

    @OnClick(R.id.myinfo_bank_account_change)
    public void onChangeBankAccount(View view) {

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

        String phone = "%d-%d-%d";
        for (EditText edit : phoneEditList) {
            phone = String.format(phone, edit.getText().toString());
        }

        String email = emailEdit.getText().toString();

        String bankAccount = bankAccountText.getText().toString();

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myinfo);

        ButterKnife.bind(this);

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

        bankAccountText.setText("하이");
    }


}