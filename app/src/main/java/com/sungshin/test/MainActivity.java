package com.sungshin.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    // 아이템 리스트
    //private String[] myDataset;
    private static ArrayList<item> itemArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, SplashActivity.class);
        startActivity(intent);

        //데이터준비-실제로는 ArrayList<>등을 사용해야 할듯 하다.
        //인터넷이나 폰에 있는 DB에서 아이템을 가져와 배열에 담아 주면 된다.
        //myDataset = new String[]{"도봉순", "이순신", "강감찬","세종대왕"};
        //ArrayList 생성
        itemArrayList = new ArrayList<>();
        //ArrayList에 값 추가하기
        itemArrayList.add(new item("1인용 테이블", 8, null));
        itemArrayList.add(new item("2인용 테이블", 4, null));
        itemArrayList.add(new item("4인용 테이블", 6, null));
        itemArrayList.add(new item("1인용 좌석", 24, null));
        itemArrayList.add(new item("2인용 좌석", 8, null));

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);//옵션
        //Linear layout manager 사용
        mLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        mRecyclerView.setLayoutManager(mLayoutManager);

        //어답터 세팅
        mAdapter = new MyAdapter(itemArrayList); //스트링 배열 데이터 인자로
        mRecyclerView.setAdapter(mAdapter);
    }


    //아이템 클라스
    public class item {
        String name;
        int count;
        String photo;

        public item(String name, int count, String photo) {
            this.name = name;
            this.count = count;
            this.photo = photo;
        }

        public String getName() {
            return name;
        }

        public int getCount() {
            return count;
        }

        public String getPhoto() { return photo; }
    }
}