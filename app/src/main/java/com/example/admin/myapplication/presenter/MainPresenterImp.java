package com.example.admin.myapplication.presenter;


import com.example.admin.myapplication.model.Users;

import java.util.ArrayList;

public interface MainPresenterImp {
    void getDataUser(String url);

    void receiverDataUsers(ArrayList<Users> arrUsers);
}
