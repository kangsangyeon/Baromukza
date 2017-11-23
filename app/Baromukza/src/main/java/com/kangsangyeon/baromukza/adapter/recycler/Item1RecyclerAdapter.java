package com.kangsangyeon.baromukza.adapter.recycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.kangsangyeon.baromukza.item.recycler.Item1ViewFieldInfoItem;
import com.kangsangyeon.baromukza.item.recycler.Item1Viewable;
import com.kangsangyeon.baromukza.viewholder.Item1ViewHolder;

import java.util.List;

/**
 * Created by pc-1 on 2017-11-13.
 */

public class Item1RecyclerAdapter extends RecyclerView.Adapter<Item1ViewHolder> {
	Context mContext;
	List<? extends Item1Viewable> items;
	int layoutId;

	public Item1RecyclerAdapter(Context context, List<? extends Item1Viewable> items, int layoutId) {
		this.mContext = context;
		this.items = items;
		this.layoutId = layoutId;
	}

	@Override
	public Item1ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View v = LayoutInflater.from(parent.getContext()).inflate(layoutId, null);

		return new Item1ViewHolder(v);
	}

	@Override
	public void onBindViewHolder(Item1ViewHolder holder, int position) {
		try{
			final Item1ViewFieldInfoItem item = items.get(position).getViewFieldInfoItem();
			final String title = item.title;
			final String content = item.content;
//			Drawable drawable = RemoteLib.drawableFromUrl(mContext, item.image);
//			holder.imageViewsetBackground(drawable);
			holder.titleText.setText(title);
			holder.contentText.setText(content);
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