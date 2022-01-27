package com.example.myapplication;

public class UserInfo {

    private String mName;
    private int mScore;


    @Override
    public String toString() {
        return "Name : " + mName +" Score: " + mScore;
    }

    public UserInfo(String mName, int mScore) {
        this.mName = mName;
        this.mScore = mScore;
    }

    public String getmName() {
        return mName;
    }

    public int getmScore() {
        return mScore;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public void setmScore(int mScore) {
        this.mScore = mScore;
    }
}
