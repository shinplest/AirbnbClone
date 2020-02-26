package com.shinplest.airbnbclone.src.search;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.shinplest.airbnbclone.R;
import com.shinplest.airbnbclone.src.house.HouseActivity;
import com.shinplest.airbnbclone.src.search.models.SimpleHouseInfoResponse;

import java.util.ArrayList;
import java.util.HashMap;

public class HousesAdapter extends RecyclerView.Adapter<HousesAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<SimpleHouseInfoResponse.Result> mHouseDataList;

    //뷰페이져 상태저장하는 hashMap
    HashMap<Integer, Integer> mViewPagerState = new HashMap<>();

    public HousesAdapter(Context context, ArrayList<SimpleHouseInfoResponse.Result> houseDataList) {
        this.context = context;
        this.mHouseDataList = houseDataList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ViewPager mVpHousePhotos;
        private TextView mTvHouseInfo, mTvStarAvg, mTvHouseName;

        public MyViewHolder(@NonNull View view) {
            super(view);
            this.mVpHousePhotos = view.findViewById(R.id.vp_house_holder);
            this.mTvHouseInfo = view.findViewById(R.id.tv_house_holder_house_info);
            this.mTvStarAvg = view.findViewById(R.id.tv_house_holder_star_avg);
            this.mTvHouseName = view.findViewById(R.id.tv_house_holder_house_name);
        }
    }


    //여기서 각각의 뷰 홀더에 리스너를 달아주고,
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View holderView = LayoutInflater.from(parent.getContext()).inflate(R.layout.holder_house, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(holderView);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        //하우스 넘버 받아오는 부분
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("OnclickTest", "onClick: " + mHouseDataList.get(position).getHouseNo());
                //여기서 하우스 넘버로 새로운 액티비티로 넘어가줘야함
                Intent intent = new Intent(v.getContext(), HouseActivity.class);
                context.startActivity(intent);
            }
        });

        SimpleHouseInfoResponse.Result house = mHouseDataList.get(position);
        //여기서 주소 받아와서 이미지 바꿔줌
//        String[] urls = house.getHouseImages().split(",");
        String url[] = {"https://pds.joins.com/news/component/htmlphoto_mmdata/201906/05/htm_20190605181513963994.jpg",
                "https://pds.joins.com/news/component/htmlphoto_mmdata/201906/05/htm_20190605181513963994.jpg",
                "https://pds.joins.com/news/component/htmlphoto_mmdata/201906/05/htm_20190605181513963994.jpg",
                "https://pds.joins.com/news/component/htmlphoto_mmdata/201906/05/htm_20190605181513963994.jpg",
                "https://pds.joins.com/news/component/htmlphoto_mmdata/201906/05/htm_20190605181513963994.jpg"};

        CustomPageAdapter customPageAdapter = new CustomPageAdapter(context, url);
        holder.mVpHousePhotos.setAdapter(customPageAdapter);
        holder.mVpHousePhotos.setId(position + 1);

        if (mViewPagerState.containsKey(position)) {
            holder.mVpHousePhotos.setCurrentItem(mViewPagerState.get(position));
        }

        holder.mTvHouseInfo.setText(house.getHouseInfo());
        holder.mTvStarAvg.setText(house.getStarAvg());
        holder.mTvHouseName.setText(house.getHouseName());
    }

    @Override
    public int getItemCount() {
        return mHouseDataList.size();
    }


}