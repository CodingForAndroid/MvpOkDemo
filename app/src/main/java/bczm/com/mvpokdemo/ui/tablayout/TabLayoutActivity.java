package bczm.com.mvpokdemo.ui.tablayout;


import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import bczm.com.mvpokdemo.R;

/**
 * @author zhangjun
 * @date 2019-8-1
 */
public class TabLayoutActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;

    List<Fragment> fragments = new ArrayList<>();
    private String[] titles = new String[]{"最新","热门","我的","热门","我的","热门"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout);

        tabLayout = findViewById(R.id.tl_tabs);
        viewPager = findViewById(R.id.vp_content);

        fragments.add(MyFragment.newInstance("11111", "11111"));
        fragments.add(MyFragment.newInstance("22222", "22222"));
        fragments.add(MyFragment.newInstance("33333", "33333"));

        fragments.add(MyFragment.newInstance("11111", "11111"));
        fragments.add(MyFragment.newInstance("22222", "22222"));
        fragments.add(MyFragment.newInstance("33333", "33333"));
        tabLayout.setupWithViewPager(viewPager,false);
        FmPagerAdapter pagerAdapter = new FmPagerAdapter(fragments,getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
//        tabLayout.setupWithViewPager(viewPager);

        for(int i=0;i<titles.length;i++){
            tabLayout.getTabAt(i).setText(titles[i]);
        }
    }

    private class FmPagerAdapter extends FragmentStatePagerAdapter{

        private FmPagerAdapter(List<Fragment> fragments,FragmentManager fm) {
            super(fm);
        }
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            super.destroyItem(container, position, object);
        }
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }


}
