package com.sungshin.test;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.RecyclerViewHolders> {

    private Context context;
    private ArrayList<ItemObject> itemList;

    //생성자
    public ReviewAdapter(Context context, ArrayList<ItemObject> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item_review, null);
        RecyclerViewHolders rcv = new RecyclerViewHolders(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, int position) {
        holder.reviewName_text.setText(itemList.get(position).getTitle());
        holder.reviewScore_text.setText(itemList.get(position).getScore());
        //holder.ivPhoto.setImageURI(itemList.get(position).getPhoto());
        Glide.with(context).load(itemList.get(position).getPhoto()).centerCrop().into(holder.reviewImage_imgae);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    //뷰홀더 클래스 정의 - 별도 파일로 하거나 어답터 안에서 정의해 줄 수 있다.
    //여기에서 반복적으로 사용되는 각종 뷰들을 정의해 준다.
    public class RecyclerViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView reviewName_text;
        public TextView reviewScore_text;
        public ImageView reviewImage_imgae;
        private Uri newUri = Uri.parse("http://클릭하면바뀔이미지.jpg");

        public RecyclerViewHolders(View itemView) {
            super(itemView);

            reviewName_text = (TextView)itemView.findViewById(R.id.reviewName);
            reviewScore_text = (TextView)itemView.findViewById(R.id.reviewScore);
            reviewImage_imgae = (ImageView)itemView.findViewById(R.id.reviewImage);

            itemView.setOnClickListener(this);

        }

        //클릭 이벤트 정의
        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(), "Clicked Card Position = " + getLayoutPosition(), Toast.LENGTH_SHORT).show();
            //이미지를 교체 하는 기능
            Glide.with(context).load(newUri).centerCrop().into(reviewImage_imgae);
        }
    }

}