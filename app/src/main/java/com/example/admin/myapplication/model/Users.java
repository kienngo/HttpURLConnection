package com.example.admin.myapplication.model;

public class Users {
    private int mId;
    private String mName;
    private String mFullName;

    public Users(int mId, String mName, String mFullName) {
        this.mId = mId;
        this.mName = mName;
        this.mFullName = mFullName;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmFullName() {
        return mFullName;
    }

    public void setmFullName(String mFullName) {
        this.mFullName = mFullName;
    }
}
