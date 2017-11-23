package com.kangsangyeon.baromukza.fragment.activity_main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kangsangyeon.baromukza.R;
import com.kangsangyeon.baromukza.adapter.recycler.Item1RecyclerAdapter;
import com.kangsangyeon.baromukza.item.RestaurantInfoItem;
import com.kangsangyeon.baromukza.lib.MySnack;
import com.kangsangyeon.baromukza.remote.RemoteService;
import com.kangsangyeon.baromukza.remote.ServiceGenerator;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by pc-1 on 2017-09-25.
 */

public class MainSearchFragment extends Fragment {

	public final String TAG = this.getClass().getSimpleName();

	@BindView(R.id.fragment_main_search_recyclerview)
	RecyclerView recyclerView;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

		final ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_main_search, container, false);

		ButterKnife.bind(this, rootView);

		LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
		recyclerView.setHasFixedSize(true);
		recyclerView.setLayoutManager(layoutManager);

		RemoteService remoteService = ServiceGenerator.createService(RemoteService.class);
		Call<ArrayList<RestaurantInfoItem>> call = remoteService.selectRestaurantInfoList();

		call.enqueue(new Callback<ArrayList<RestaurantInfoItem>>() {
			@Override
			public void onResponse(Call<ArrayList<RestaurantInfoItem>> call, Response<ArrayList<RestaurantInfoItem>> response) {
				ArrayList<RestaurantInfoItem> items = response.body();

				if (items != null) {
					recyclerView.setAdapter(new Item1RecyclerAdapter(getActivity(), items, R.layout.item_type1_1));
				}
				else {
					MySnack.show(rootView, getString(R.string.error_nodata));
				}
			}

			@Override
			public void onFailure(Call<ArrayList<RestaurantInfoItem>> call, Throwable t) {
				MySnack.show(rootView, getString(R.string.error_internet));
				t.printStackTrace();
			}
		});

		return rootView;
	}

}
