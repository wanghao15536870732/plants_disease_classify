package com.example.resnettest.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.example.resnettest.DetailActivity;
import com.example.resnettest.bean.CardItem;
import com.example.resnettest.R;

import java.util.ArrayList;
import java.util.List;

public class CardPagerAdapter extends PagerAdapter implements CardAdapter {

    private Context mContext;
    private List<CardView> mViews;
    private List<CardItem> mData;
    private float mBaseElevation;

    public CardPagerAdapter(Context context) {
        mContext = context;
        mData = new ArrayList<>();
        mViews = new ArrayList<>();
    }

    public void addCardItem(CardItem item) {
        mViews.add(null);
        mData.add(item);
    }

    public float getBaseElevation() {
        return mBaseElevation;
    }

    @Override
    public CardView getCardViewAt(int position) {
        return mViews.get(position);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.card_item, container, false);
        container.addView(view);
        bind(mData.get(position), view);
        CardView cardView = view.findViewById(R.id.cardView);

        if (mBaseElevation == 0) {
            mBaseElevation = cardView.getCardElevation();
        }

        cardView.setMaxCardElevation(mBaseElevation * MAX_ELEVATION_FACTOR);
        mViews.set(position, cardView);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
        mViews.set(position, null);
    }

    private void bind(CardItem item, View view) {
        TextView titleTextView = view.findViewById(R.id.titleTextView);
        TextView contentTextView = view.findViewById(R.id.contentTextView);
        Button reTakeBtn = view.findViewById(R.id.re_take_btn);
        Button moreBtn = view.findViewById(R.id.more_btn);
        titleTextView.setText(item.getTitle());
        contentTextView.setText(item.getText());
        if(item.isScore_show()){
            view.findViewById(R.id.score_label).setVisibility(View.VISIBLE);
            reTakeBtn.setVisibility(View.GONE);
            moreBtn.setOnClickListener(v -> {
                if (!item.getText().equals("")){
                    Intent intent = new Intent(mContext, DetailActivity.class);
                    intent.putExtra("link",item.getLink());
                    intent.putExtra("title",item.getTitle());
                    mContext.startActivity(intent);
                }
            });
        }else {
            view.findViewById(R.id.score_label).setVisibility(View.GONE);
            moreBtn.setText("错误反馈");
            reTakeBtn.setVisibility(View.VISIBLE);
            reTakeBtn.setText("重新拍照");
        }
    }
}