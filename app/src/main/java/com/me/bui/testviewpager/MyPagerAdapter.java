package com.me.bui.testviewpager;

import android.icu.util.Freezable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mao.bui on 2/25/2019.
 */
public class MyPagerAdapter extends SmartFragmentStatePagerAdapter<PageFragment> {
    private List<PageFragment> mPageFragments = new ArrayList<>();


    public MyPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    // Returns total number of pages
    @Override
    public int getCount() {
        return mPageFragments.size();
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
//        switch (position) {
//            case 0: // Fragment # 0 - This will show FirstFragment
//                return PageFragment.newInstance(0, "Page # 1");
//            case 1: // Fragment # 0 - This will show FirstFragment different title
//                return PageFragment.newInstance(1, "Page # 2");
//            case 2: // Fragment # 1 - This will show SecondFragment
//                return PageFragment.newInstance(2, "Page # 3");
//            default:
//                return null;
//        }
        return mPageFragments.get(position);
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
//        return "Page " + position;
        return "";
    }

    public void setPageFragments(List<PageFragment> pageFragments) {
        mPageFragments = pageFragments;
        notifyDataSetChanged();
    }

}
