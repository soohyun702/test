package com.sungshin.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //여기는 편의시설
    private RecyclerView recyclerView_convenience;
    private CovenienceAdapter adapter_convenience;
    private GridLayoutManager layoutManager;

    ArrayList<IconItem> list = new ArrayList<IconItem>() {{
        add(new IconItem("와이파이",R.drawable.wifi_on));
        add(new IconItem("혼밥",R.drawable.reserve_on));
        add(new IconItem("콘센트",R.drawable.plug_on));
        add(new IconItem("주차이용",R.drawable.car_on));
        add(new IconItem("예약주문",R.drawable.call_on));

    }};


    //여기는 테이블 좌석
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    //여기부터 밑은 review
    private static final String TAG = "MainActivity";

    private ArrayList<ItemObject> rowListItem;
    private ReviewAdapter reviewAdapter;
    private LinearLayoutManager mLinearLayoutManager;
    private RecyclerView recyclerView;
    Uri mUri = null;


    // 테이블 좌석의 아이템 리스트
    //private String[] myDataset;
    private static ArrayList<item> itemArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //스플래시
        Intent intent = new Intent(this, SplashActivity.class);
        startActivity(intent);

        recyclerView_convenience = (RecyclerView)findViewById(R.id.my_recycler_view_convenience);
        adapter_convenience = new  CovenienceAdapter(getApplicationContext(), list);
        layoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView_convenience.setLayoutManager(layoutManager);
        recyclerView_convenience.setHasFixedSize(true);
        recyclerView_convenience.setAdapter(adapter_convenience);


        //이밑으로 review관련
        rowListItem = getAllItemList();
        mLinearLayoutManager = new GridLayoutManager(MainActivity.this, 2);
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view1);
        recyclerView.setLayoutManager(mLinearLayoutManager);
        reviewAdapter = new ReviewAdapter(this, rowListItem);
        recyclerView.setAdapter(reviewAdapter);


        //이 밑으로 테이블/좌석
        //데이터준비-실제로는 ArrayList<>등을 사용해야 할듯 하다.
        //인터넷이나 폰에 있는 DB에서 아이템을 가져와 배열에 담아 주면 된다.
        //myDataset = new String[]{"도봉순", "이순신", "강감찬","세종대왕"};
        //ArrayList 생성
        itemArrayList = new ArrayList<>();
        //ArrayList에 값 추가하기
        itemArrayList.add(new item("1인용 테이블", 8, R.mipmap.image1));
        itemArrayList.add(new item("2인용 테이블", 4, R.mipmap.image2));
        itemArrayList.add(new item("4인용 테이블", 6, R.mipmap.image3));
        itemArrayList.add(new item("1인용 좌석", 24, R.mipmap.image1));
        itemArrayList.add(new item("2인용 좌석", 8, R.mipmap.image1));

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);//옵션
        //Linear layout manager 사용
        mLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        mRecyclerView.setLayoutManager(mLayoutManager);

        //어답터 세팅
        mAdapter = new MyAdapter(itemArrayList); //스트링 배열 데이터 인자로
        mRecyclerView.setAdapter(mAdapter);
    }

    private ArrayList<ItemObject> getAllItemList(){
        mUri = Uri.parse("http://sample.png");
        //Log.d(TAG, "uri: " + String.valueOf(mUri));
        ArrayList<ItemObject> allItems = new ArrayList<ItemObject>();
        allItems.add(new ItemObject("정말 맛집","★★★★★", mUri));
        allItems.add(new ItemObject("맛없어요", "★★☆☆☆", mUri));
        allItems.add(new ItemObject("서비스 최고","★★★★☆", mUri));
        allItems.add(new ItemObject("맛있어요","★★★★☆", mUri));
        allItems.add(new ItemObject("다시 올 법한 가게", "★★★★★", mUri));

        return allItems;
    }

    //테이블 좌석 아이템 클라스
    public class item {
        String name;
        int count;
        int photo;

        public item(String name, int count, int photo) {
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

        public int getPhoto() { return photo; }
    }
}