package com.sungshin.test;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyPageLogin extends AppCompatActivity {
    private RecyclerView recyclerView_mypage_login;
    private MyPageLoginAdapter adapter_mypage_login;
    private GridLayoutManager layoutManager_login;

    ArrayList<MyPageLoginItem> list = new ArrayList<MyPageLoginItem>() {{
        add(new MyPageLoginItem("카테고리",R.drawable.my_page1));
        add(new MyPageLoginItem("찜",R.drawable.my_page2));
        add(new MyPageLoginItem("리뷰작성",R.drawable.my_page3));
        add(new MyPageLoginItem("작성한 리뷰",R.drawable.my_page4));

    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView_mypage_login = (RecyclerView)findViewById(R.id.myPageLog_recyclerView);
        adapter_mypage_login = new MyPageLoginAdapter(getApplicationContext(), list);
        layoutManager_login = new GridLayoutManager(getApplicationContext(), 4);
        recyclerView_mypage_login.setLayoutManager(layoutManager_login);
        recyclerView_mypage_login.setHasFixedSize(true);
        recyclerView_mypage_login.setAdapter(adapter_mypage_login);

    }
}
