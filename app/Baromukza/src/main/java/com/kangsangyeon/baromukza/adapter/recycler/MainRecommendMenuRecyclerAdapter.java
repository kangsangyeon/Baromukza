package com.kangsangyeon.baromukza.adapter.recycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.kangsangyeon.baromukza.R;
import com.kangsangyeon.baromukza.item.RestaurantMenuInfoItem;
import com.kangsangyeon.baromukza.viewholder.Item2ViewHolder;

import java.util.List;

/**
 * Created by pc-1 on 2017-11-13.
 */

public class MainRecommendMenuRecyclerAdapter extends RecyclerView.Adapter<Item2ViewHolder> {
	Context mContext;
	List<RestaurantMenuInfoItem> items;

	public MainRecommendMenuRecyclerAdapter(Context context, List<RestaurantMenuInfoItem> items) {
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
			final RestaurantMenuInfoItem item = items.get(position);
//			Drawable drawable = RemoteLib.drawableFromUrl(mContext, item.image);
//			holder.imageView.setBackground(drawable);
			holder.titleText.setText(item.name);
			holder.contentText.setText(item.price + "원");
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