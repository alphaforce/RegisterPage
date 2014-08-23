package com.example.registerpage;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Songful on 2014/8/23.
 */
public class RegSuccessActivity extends Activity {
    private TextView mUsernameTv;
    private TextView mPasswdTv;
    private TextView mSexTv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reg_success);

        mUsernameTv = (TextView) findViewById(R.id.succ_username);
        mPasswdTv = (TextView) findViewById(R.id.succ_passwd);
        mSexTv = (TextView) findViewById(R.id.succ_sex);

        Bundle data = getIntent().getExtras();
        if(data != null){
            RegInfo regInfo = (RegInfo) data.get("regInfo");
            mUsernameTv.setText(regInfo.getUsername());
            mPasswdTv.setText(regInfo.getPasswd());
            mSexTv.setText(regInfo.getSex().getValue());
        }
    }


}