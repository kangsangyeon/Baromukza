package com.kangsangyeon.baromukza.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.kangsangyeon.baromukza.fragment.activity_main.MainRecommendFragment;
import com.kangsangyeon.baromukza.fragment.activity_main.MainMapFragment;
import com.kangsangyeon.baromukza.fragment.activity_main.MainSearchFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pc-1 on 2017-11-12.
 */

public class MainViewPagerAdapter extends FragmentStatePagerAdapter {

    List<Fragment> fragmentList = new ArrayList<>();
    String[] pageTitleArr;

    public MainViewPagerAdapter(FragmentManager fm) {
        super(fm);

        fragmentList.add(new MainRecommendFragment());
        fragmentList.add(new MainSearchFragment());
        fragmentList.add(new MainMapFragment());
        pageTitleArr = new String[]{"추천", "검색", "지도"};
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return pageTitleArr[position];
    }
}
