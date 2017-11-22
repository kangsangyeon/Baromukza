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
import com.kangsangyeon.baromukza.item.RestaurantMenuInfoItem;
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

public class MainRecommendFragment extends Fragment{

    public final String TAG = this.getClass().getSimpleName();

    @BindView(R.id.fragment_main_recommend_menu_recyclerview)
	RecyclerView menuRecyclerView;
	@BindView(R.id.fragment_main_recommend_recent_recyclerview)
	RecyclerView recentRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_main_recommend, container, false);

		ButterKnife.bind(this, rootView);


		// 추천 메뉴 리사이클러뷰 초기화
		// TODO: 메뉴 추천기능이 아직 없다.. 메뉴 추천을 어떻게 할지부터 고민해보자
		LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
		menuRecyclerView.setHasFixedSize(true);
		menuRecyclerView.setLayoutManager(layoutManager);

		RemoteService remoteService = ServiceGenerator.createService(RemoteService.class);
		Call<ArrayList<RestaurantMenuInfoItem>> geMenuListCall = remoteService.selectRestaurantMenuInfoList();
		geMenuListCall.enqueue(new Callback<ArrayList<RestaurantMenuInfoItem>>() {
			@Override
			public void onResponse(Call<ArrayList<RestaurantMenuInfoItem>> call, Response<ArrayList<RestaurantMenuInfoItem>> response) {
				ArrayList<RestaurantMenuInfoItem> items = response.body();

				if (items != null) {
					menuRecyclerView.setAdapter(new Item1RecyclerAdapter(getActivity(), items, R.layout.item_type1_2));
				}
				else {
					MySnack.show(rootView, "데이터 못가져왔어욤 ㅠㅅㅠ");
				}
			}

			@Override
			public void onFailure(Call<ArrayList<RestaurantMenuInfoItem>> call, Throwable t) {
				MySnack.show(rootView, "데이터를 가져오는 데 실패하였습니다.");
				t.printStackTrace();
			}
		});

		// 최근 음식점 리사이클러뷰 초기화
		// TODO: 최근 음식점 기능을 아직 만들지 않아서 먼저는 최근 음식점 리스트가 아닌 전체 리스트를 가져오도록 구현하였다. 만들자..
		layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
		recentRecyclerView.setHasFixedSize(true);
		recentRecyclerView.setLayoutManager(layoutManager);

		Call<ArrayList<RestaurantInfoItem>> getRecentRestaurantCall = remoteService.selectRestaurantInfoList();
		getRecentRestaurantCall.enqueue(new Callback<ArrayList<RestaurantInfoItem>>() {
			@Override
			public void onResponse(Call<ArrayList<RestaurantInfoItem>> call, Response<ArrayList<RestaurantInfoItem>> response) {
				ArrayList<RestaurantInfoItem> items = response.body();

				if (items != null) {
					recentRecyclerView.setAdapter(new Item1RecyclerAdapter(getActivity(), items, R.layout.item_type1_2));
				}
				else {
					MySnack.show(rootView, "데이터 못가져왔어욤 ㅠㅅㅠ");
				}
			}

			@Override
			public void onFailure(Call<ArrayList<RestaurantInfoItem>> call, Throwable t) {
				MySnack.show(rootView, "데이터를 가져오는 데 실패하였습니다.");
				t.printStackTrace();
			}
		});

        return rootView;
    }

}
