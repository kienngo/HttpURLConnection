package com.example.admin.myapplication.model;

import android.os.Handler;
import android.os.Message;

import com.example.admin.myapplication.model.api.CallApi;
import com.example.admin.myapplication.presenter.MainPresenter;

import java.util.ArrayList;

public class GetDataUsers implements GetDataUsersImp {
    public static final int WHAT_CALL_API = 1;
    private ArrayList<Users> mArrUsers = new ArrayList<>();
    private MainPresenter mMainPresenter;

    public GetDataUsers(MainPresenter mainPresenter) {
        this.mMainPresenter = mainPresenter;
    }

    @Override
    public void callApiGetData(String url) {
        new CallApi(mHandler).execute(url);
    }

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == WHAT_CALL_API) {
                mArrUsers.addAll((ArrayList<Users>) msg.obj);
                mMainPresenter.receiverDataUsers(mArrUsers);
            }
        }
    };
}
