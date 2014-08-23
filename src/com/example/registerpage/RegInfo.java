package com.example.registerpage;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Songful on 2014/8/23.
 */
public class RegInfo implements Parcelable{
    private String mUsername;
    private String mPasswd;
    private Sex mSex;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mUsername);
        dest.writeString(mPasswd);
        dest.writeString(mSex.getValue());
    }

    public static final Creator<RegInfo> CREATOR = new Creator<RegInfo>() {
        @Override
        public RegInfo createFromParcel(Parcel source) {
            RegInfo regInfo = new RegInfo();
            regInfo.setUsername(source.readString());
            regInfo.setPasswd(source.readString());
            regInfo.setSex(source.readString().equals(Sex.male.getValue())? Sex.male: Sex.female);
            return regInfo;
        }

        @Override
        public RegInfo[] newArray(int size) {
            return new RegInfo[0];
        }
    };

    enum Sex {
        male("男"), female("女");
        private String value;

        private Sex(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
    }

    public String getPasswd() {
        return mPasswd;
    }

    public void setPasswd(String passwd) {
        mPasswd = passwd;
    }

    public Sex getSex() {
        return mSex;
    }

    public void setSex(Sex sex) {
        mSex = sex;
    }
}
