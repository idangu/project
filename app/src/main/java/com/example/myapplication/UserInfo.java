package com.example.myapplication;

public class UserInfo implements Comparable<UserInfo> {

    private String mName;
    private int mScore;


    @Override
    public String toString() {
        return App.getContext().getResources().getString(R.string.name) + mName + " " + App.getContext().getResources().getString(R.string.scoreTitle) + mScore;
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

    @Override
    public int compareTo(UserInfo userInfo) {
        return Integer.compare(userInfo.mScore, this.mScore);
    }
}
