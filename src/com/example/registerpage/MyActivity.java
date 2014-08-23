package com.example.registerpage;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MyActivity extends Activity {
    private EditText mUsernameEdit;
    private EditText mPasswordEdit;
    private RadioButton mMaleRadio;
    private RadioButton mFemaleRadio;
    private Button mRegisterBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mUsernameEdit = (EditText) findViewById(R.id.username);
        mPasswordEdit = (EditText) findViewById(R.id.password);
        mMaleRadio = (RadioButton) findViewById(R.id.male_radio);
        mFemaleRadio = (RadioButton) findViewById(R.id.female_radio);
        mRegisterBtn = (Button) findViewById(R.id.reg_btn);

        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isEditsEmpty()){
                    AlertDialog.Builder builder = new AlertDialog.Builder(MyActivity.this);

                    builder.setMessage("注册信息不能为空");
                    builder.setTitle("提示");
                    builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    builder.create().show();
                }else {
                    Intent it = new Intent(MyActivity.this, RegSuccessActivity.class);
                    Bundle data = new Bundle();
                    data.putParcelable("regInfo", generateRegInfo());
                    it.putExtras(data);
                    startActivity(it);
                }
            }
        });


    }

    private boolean isEditsEmpty(){
        String username = mUsernameEdit.getText().toString();
        String pw = mPasswordEdit.getText().toString();

        return username.isEmpty() || pw.isEmpty();
    }

    private RegInfo generateRegInfo(){
        RegInfo regInfo = new RegInfo();
        regInfo.setUsername(mUsernameEdit.getText().toString());
        regInfo.setPasswd(mPasswordEdit.getText().toString());
        if(mMaleRadio.isChecked()){
            regInfo.setSex(RegInfo.Sex.male);
        }else {
            regInfo.setSex(RegInfo.Sex.female);
        }

        return regInfo;
    }
}
