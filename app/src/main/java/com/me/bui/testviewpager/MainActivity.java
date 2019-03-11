package com.me.bui.testviewpager;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

//    private SmartFragmentStatePagerAdapter adapterViewPager;
    private MyPagerAdapter adapterViewPager;
    private List<PageFragment> mPageFragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ViewPager vpPager = findViewById(R.id.vpPager);
        TabLayout tabLayout = findViewById(R.id.tabDots);
        tabLayout.setupWithViewPager(vpPager, true);

        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);
        for(int i = 0; i < 4; i++) {
            mPageFragments.add(PageFragment.newInstance(i, "Page" + i));
        }
        adapterViewPager.setPageFragments(mPageFragments);

        // Attach the page change listener inside the activity
        vpPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            // This method will be invoked when a new page becomes selected.
            @Override
            public void onPageSelected(int position) {
                Toast.makeText(MainActivity.this,
                        "Selected page position: " + position, Toast.LENGTH_SHORT).show();
            }

            // This method will be invoked when the current page is scrolled
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // Code goes here
            }

            // Called when the scroll state changes:
            // SCROLL_STATE_IDLE, SCROLL_STATE_DRAGGING, SCROLL_STATE_SETTLING
            @Override
            public void onPageScrollStateChanged(int state) {
                // Code goes here
            }
        });
        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnSwitch = findViewById(R.id.btnSwitch);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPageFragments.add(PageFragment.newInstance(mPageFragments.size(), "Page" + mPageFragments.size()));
                adapterViewPager.notifyDataSetChanged();
                vpPager.setCurrentItem(mPageFragments.size() -1, true);
            }
        });

        btnSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPageFragments.get(0).changeTitle("aaaaaaaaaaaaaaaaa");
//                adapterViewPager.notifyDataSetChanged();
//                adapterViewPager.getRegisteredFragment(0).changeTitle("aaaaaaaaaaaaaaaaa");
                vpPager.setCurrentItem(0);
            }
        });
    }

}
