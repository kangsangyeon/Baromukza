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
import com.kangsangyeon.baromukza.adapter.recycler.MainRecommendRecyclerAdapter;
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

    @BindView(R.id.fragment_main_recommend_recyclerview)
	RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_main_recommend, container, false);

		ButterKnife.bind(this, rootView);

		LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
		recyclerView.setHasFixedSize(true);
		recyclerView.setLayoutManager(layoutManager);

		RemoteService remoteService = ServiceGenerator.createService(RemoteService.class);
		Call<ArrayList<RestaurantMenuInfoItem>> call = remoteService.selectRestaurantMenuInfoList();

		call.enqueue(new Callback<ArrayList<RestaurantMenuInfoItem>>() {
			@Override
			public void onResponse(Call<ArrayList<RestaurantMenuInfoItem>> call, Response<ArrayList<RestaurantMenuInfoItem>> response) {
				ArrayList<RestaurantMenuInfoItem> items = response.body();

				if (items != null) {
					recyclerView.setAdapter(new MainRecommendRecyclerAdapter(getActivity(), items));
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



        return rootView;

    }

}
