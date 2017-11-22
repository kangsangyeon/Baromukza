package com.kangsangyeon.baromukza.viewholder;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.kangsangyeon.baromukza.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by pc-1 on 2017-11-13.
 */

public class Item2ViewHolder extends RecyclerView.ViewHolder {

	@BindView(R.id.cardview) public CardView cardView;
	@BindView(R.id.image) public ImageView imageView;
	@BindView(R.id.title) public TextView titleText;
	@BindView(R.id.content) public TextView contentText;
	@BindView(R.id.content2) public TextView content2Text;
	@BindView(R.id.content3) public TextView content3Text;

	public Item2ViewHolder(View itemView) {
		super(itemView);

		ButterKnife.bind(this, itemView);
	}

}
