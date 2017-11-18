package com.kangsangyeon.baromukza.viewholder;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.kangsangyeon.baromukza.R;
import com.kangsangyeon.baromukza.item.RestaurantInfoItem;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by pc-1 on 2017-11-13.
 */

public class RestaurantViewHolder extends RecyclerView.ViewHolder {

	@BindView(R.id.cardview) public CardView cardView;
	@BindView(R.id.image) public ImageView imageView;
	@BindView(R.id.title) public TextView titleText;

	RestaurantInfoItem restaurantInfoItem;

	public RestaurantViewHolder(View itemView) {
		super(itemView);

		ButterKnife.bind(this, itemView);
	}

}
