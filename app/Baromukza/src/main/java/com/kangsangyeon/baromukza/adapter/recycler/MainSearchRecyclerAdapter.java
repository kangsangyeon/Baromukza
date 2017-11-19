package com.kangsangyeon.baromukza.adapter.recycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.kangsangyeon.baromukza.R;
import com.kangsangyeon.baromukza.item.RestaurantInfoItem;
import com.kangsangyeon.baromukza.viewholder.RestaurantViewHolder;

import java.util.List;

/**
 * Created by pc-1 on 2017-11-13.
 */

public class MainSearchRecyclerAdapter extends RecyclerView.Adapter<RestaurantViewHolder> {
	Context mContext;
	List<RestaurantInfoItem> items;
	int item_layout;

	public MainSearchRecyclerAdapter(Context context, List<RestaurantInfoItem> items, int item_layout) {
		this.mContext = context;
		this.items = items;
		this.item_layout = item_layout;
	}

	@Override
	public RestaurantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_1, null);

		return new RestaurantViewHolder(v);
	}

	@Override
	public void onBindViewHolder(RestaurantViewHolder holder, int position) {
		try{
			final RestaurantInfoItem item = items.get(position);
//			Drawable drawable = RemoteLib.drawableFromUrl(mContext, item.image);
//			holder.imageView.setBackground(drawable);
			holder.titleText.setText(item.name);
			holder.contentText.setText(item.description);
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