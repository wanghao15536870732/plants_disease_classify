package com.example.resnettest.adapter;

import androidx.cardview.widget.CardView;

public interface CardAdapter {
    int MAX_ELEVATION_FACTOR = 10;
    float getBaseElevation();
    CardView getCardViewAt(int position);
    int getCount();
}
