package com.example.admin.myapplication.presenter;

import com.example.admin.myapplication.model.GetDataUsers;
import com.example.admin.myapplication.model.Users;
import com.example.admin.myapplication.view.MainImp;

import java.util.ArrayList;

public class MainPresenter implements MainPresenterImp {
    private MainImp mMainImp;
    private GetDataUsers mGetDataUsers;

    public MainPresenter(MainImp mainImp) {
        this.mMainImp = mainImp;
        mGetDataUsers = new GetDataUsers(this);
    }

    @Override
    public void getDataUser(String url) {
        mGetDataUsers.callApiGetData(url);
    }

    @Override
    public void receiverDataUsers(ArrayList<Users> arrUsers) {
        mMainImp.resultData(arrUsers);
    }
}
