package com.sungshin.test;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyPage extends AppCompatActivity {

    private RecyclerView recyclerView_mypage;
    private MyPageAdapter adapter_mypage;
    private GridLayoutManager layoutManager;

    ArrayList<MyPageItem> list = new ArrayList<MyPageItem>() {{
        add(new MyPageItem("카테고리",R.drawable.my_page1));
        add(new MyPageItem("찜",R.drawable.my_page2));
        add(new MyPageItem("리뷰작성",R.drawable.my_page3));
        add(new MyPageItem("작성한 리뷰",R.drawable.my_page4));

    }};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView_mypage = (RecyclerView)findViewById(R.id.myPage_recyclerView);
        adapter_mypage = new MyPageAdapter(getApplicationContext(), list);
        layoutManager = new GridLayoutManager(getApplicationContext(), 4);
        recyclerView_mypage.setLayoutManager(layoutManager);
        recyclerView_mypage.setHasFixedSize(true);
        recyclerView_mypage.setAdapter(adapter_mypage);

    }
}
