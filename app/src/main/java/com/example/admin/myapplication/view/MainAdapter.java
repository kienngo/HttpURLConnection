package com.example.admin.myapplication.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.myapplication.R;
import com.example.admin.myapplication.model.Users;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {
    private List<Users> mArrUsers;
    private Context mContext;

    public MainAdapter(List<Users> arrUsers, Context context) {
        this.mArrUsers = arrUsers;
        this.mContext = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_main, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Users user = mArrUsers.get(position);
        holder.mTextId.setText(String.valueOf(user.getmId()));
        holder.mTextName.setText(user.getmName());
        holder.mTextFullName.setText(user.getmFullName());
    }

    @Override
    public int getItemCount() {
        return mArrUsers.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView mTextId, mTextName, mTextFullName;

        public MyViewHolder(View itemView) {
            super(itemView);

            mTextId = (TextView) itemView.findViewById(R.id.textview_id);
            mTextName = (TextView) itemView.findViewById(R.id.textview_name);
            mTextFullName = (TextView) itemView.findViewById(R.id.textview_full_name);
        }
    }
}
