package com.x7.ssad.ticketsystem.Activities;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.x7.ssad.ticketsystem.Fragments.CinemaFragment;
import com.x7.ssad.ticketsystem.Fragments.MineFragment;
import com.x7.ssad.ticketsystem.Fragments.MovieFragment;
import com.x7.ssad.ticketsystem.R;

public class MainActivity extends AppCompatActivity {
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setOffscreenPageLimit(2);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(mViewPager);

        tabLayout.getTabAt(0).setCustomView(getLayoutInflater().inflate(R.layout.activity_main_tab1, null));
        tabLayout.getTabAt(1).setCustomView(getLayoutInflater().inflate(R.layout.activity_main_tab2, null));
        tabLayout.getTabAt(2).setCustomView(getLayoutInflater().inflate(R.layout.activity_main_tab3, null));
    }
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        private Fragment movieFragment;
        private Fragment cinemaFragment;
        private Fragment mineFragment;

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                if (movieFragment == null) {
                    movieFragment = new MovieFragment();
                }
                return movieFragment;
            }
            else if (position == 1) {
                if (cinemaFragment == null) {
                    cinemaFragment = new CinemaFragment();
                }
                return cinemaFragment;
            }
            else if (position == 2) {
                if (mineFragment == null) {
                    mineFragment = new MineFragment();
                }
                return mineFragment;
            }
            else {
                return null;
            }
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return null;
        }
    }

}
