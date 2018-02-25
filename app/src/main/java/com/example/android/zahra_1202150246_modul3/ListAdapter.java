package com.example.android.zahra_1202150246_modul3;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.LinkedList;

public class ListAdapter extends
        RecyclerView.Adapter<ListAdapter.WordViewHolder>   {

    private final LinkedList<String> mTitleList;
    private final LinkedList<String> mSubTitleList;
    private final LinkedList<Integer> mBackgroundList;
    private LayoutInflater mInflater;

    public ListAdapter(Context context, LinkedList<String> TitleList, LinkedList<String> SubTitleList, LinkedList<Integer> BackgroundList) {
        mInflater = LayoutInflater.from(context);
        this.mTitleList = TitleList;
        this.mSubTitleList = SubTitleList;
        this.mBackgroundList = BackgroundList;
    }

    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.activity_list_adapter, parent, false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        final String mCurrentTitle = mTitleList.get(position);
        final String mCurrentSubTitle = mSubTitleList.get(position);
        final Integer mCurrentBackground = mBackgroundList.get(position);
        holder.titleItemView.setText(mCurrentTitle);
        holder.subtitleItemView.setText(mCurrentSubTitle);
        holder.cardView.setBackgroundResource(mCurrentBackground);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),DetailActivity.class);
                intent.putExtra("Title",mCurrentTitle);
                intent.putExtra("Background",mCurrentBackground);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mTitleList.size();
    }

    public class WordViewHolder extends RecyclerView.ViewHolder {
        public final TextView titleItemView, subtitleItemView;
        public final CardView cardView;
        final ListAdapter mAdapter;
        public WordViewHolder(View itemView, ListAdapter adapter) {
            super(itemView);
            titleItemView = (TextView) itemView.findViewById(R.id.title);
            subtitleItemView = (TextView) itemView.findViewById(R.id.subTitle);
            cardView = (CardView)itemView.findViewById(R.id.listBackground);
            this.mAdapter = adapter;
        }
    }
}