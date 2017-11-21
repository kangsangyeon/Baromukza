package com.kangsangyeon.baromukza.adapter.recycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.kangsangyeon.baromukza.R;
import com.kangsangyeon.baromukza.item.RestaurantInfoItem;
import com.kangsangyeon.baromukza.viewholder.Item2ViewHolder;

import java.util.List;

/**
 * Created by pc-1 on 2017-11-13.
 */

public class MainRecommendRecentRecyclerAdapter extends RecyclerView.Adapter<Item2ViewHolder> {
	Context mContext;
	List<RestaurantInfoItem> items;

	public MainRecommendRecentRecyclerAdapter(Context context, List<RestaurantInfoItem> items) {
		this.mContext = context;
		this.items = items;
	}

	@Override
	public Item2ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_2, null);

		return new Item2ViewHolder(v);
	}

	@Override
	public void onBindViewHolder(Item2ViewHolder holder, int position) {
		try{
			final RestaurantInfoItem item = items.get(position);
//			Drawable drawable = RemoteLib.drawableFromUrl(mContext, item.image);
//			holder.imageView.setBackground(drawable);
			holder.titleText.setText(item.name);
			// TODO: 업종이 무엇인지 뜨게 하게 하거나.. 뭐 하여튼 부가적인 설명이 뜨게끔 바꾸기
			holder.contentText.setText(item.name);
			holder.cardView.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Toast.makeText(mContext, item.name, Toast.LENGTH_SHORT).show();
				}
			});
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public int getItemCount() {
		return this.items.size();
	}
}