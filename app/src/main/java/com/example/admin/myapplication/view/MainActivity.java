package com.example.admin.myapplication.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.admin.myapplication.R;
import com.example.admin.myapplication.model.Users;
import com.example.admin.myapplication.presenter.MainPresenter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainImp {
    private final String URL = "https://api.github.com/users/google/repos";

    private MainPresenter mMainPresenter;
    private MainAdapter mMainAdapter;
    private RecyclerView mRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecycler = (RecyclerView) findViewById(R.id.recycler_users);

        mMainPresenter = new MainPresenter(this);
        mMainPresenter.getDataUser(URL);
    }

    @Override
    public void resultData(ArrayList<Users> arrUsers) {
        mMainAdapter = new MainAdapter(arrUsers, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        mRecycler.setLayoutManager(layoutManager);
        mRecycler.setAdapter(mMainAdapter);
    }
}
