package com.example.vollyrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class githubAdapter extends RecyclerView.Adapter<githubAdapter.userdata> {

    private Context context;
    private user[] data;

    public githubAdapter(Context context,user[] data) {
        this.context = context;
        this.data = data;

    }

    @NonNull
    @Override
    public userdata onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view  = layoutInflater.inflate(R.layout.user_info,parent,false);
        return new userdata(view);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    @Override
    public void onBindViewHolder(@NonNull userdata holder, int position) {
        user user = data[position];
        holder.username.setText(user.getLogin());
        Glide.with(holder.userimg.getContext()).load(user.getAvatarUrl()).into(holder.userimg);


    }

    public class userdata extends RecyclerView.ViewHolder{
        ImageView userimg;
        TextView username;
        public userdata(@NonNull View itemView) {
            super(itemView);
            userimg = itemView.findViewById(R.id.userimg);
            username = itemView.findViewById(R.id.username);

        }
    }
}
