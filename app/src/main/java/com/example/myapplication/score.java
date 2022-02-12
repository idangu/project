package com.example.myapplication;

import android.app.ListActivity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class score extends AppCompatActivity  {

    ArrayList<UserInfo> mUsers = new ArrayList<>();
    SharedPreferences mUserInfo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        ListView listView = findViewById(R.id.listView);
        mUserInfo = getSharedPreferences("users", MODE_PRIVATE);
        int size = mUserInfo.getInt("size", 0);

        for (int i = 1; i <= size; i++) {
            mUsers.add(new UserInfo(mUserInfo.getString("userName_" + i, "Unknown"),mUserInfo.getInt("userScore_" + i, 0)));
        }
        Collections.sort(mUsers);
        ArrayAdapter<UserInfo> itemsAdapter =
                new ArrayAdapter<UserInfo>(this, android.R.layout.simple_list_item_1, mUsers);

        listView.setAdapter(itemsAdapter);
    }
    }