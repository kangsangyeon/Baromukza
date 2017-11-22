package com.kangsangyeon.baromukza.adapter.recycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.kangsangyeon.baromukza.item.recycler.Item2ViewFieldInfoItem;
import com.kangsangyeon.baromukza.item.recycler.Item2Viewable;
import com.kangsangyeon.baromukza.viewholder.Item2ViewHolder;

import java.util.List;

/**
 * Created by pc-1 on 2017-11-13.
 */

public class Item2RecyclerAdapter extends RecyclerView.Adapter<Item2ViewHolder> {
	Context mContext;
	List<? extends Item2Viewable> items;
	int layoutId;

	public Item2RecyclerAdapter(Context context, List<? extends Item2Viewable> items, int layoutId) {
		this.mContext = context;
		this.items = items;
		this.layoutId = layoutId;
	}

	@Override
	public Item2ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View v = LayoutInflater.from(parent.getContext()).inflate(layoutId, null);

		return new Item2ViewHolder(v);
	}

	@Override
	public void onBindViewHolder(Item2ViewHolder holder, int position) {
		try{
			final Item2ViewFieldInfoItem item = items.get(position).getViewFieldInfoItem();
			final String title = item.title;
			final String content = item.content;
			final String content2 = item.content2;
			final String content3 = item.content3;
//			Drawable drawable = RemoteLib.drawableFromUrl(mContext, item.image);
//			holder.imageView.setBackground(drawable);
			holder.titleText.setText(title);
			holder.contentText.setText(content);
			holder.content2Text.setText(content2);
			holder.content3Text.setText(content3);
			holder.cardView.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Toast.makeText(mContext, title, Toast.LENGTH_SHORT).show();
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