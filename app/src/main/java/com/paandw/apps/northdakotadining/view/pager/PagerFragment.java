package com.paandw.apps.northdakotadining.view.pager;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hannesdorfmann.fragmentargs.FragmentArgs;
import com.paandw.apps.northdakotadining.R;
import com.paandw.apps.northdakotadining.view.menu.MenuFragmentBuilder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PagerFragment extends Fragment {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.tv_selected_date)
    TextView tvSelectedDate;
    @BindView(R.id.view_pager)
    ViewPager viewPager;

    public PagerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pager, container, false);
        FragmentArgs.inject(this);
        ButterKnife.bind(this, view);
        setupToolbar();
        setupViewPager();
        viewPager.setOffscreenPageLimit(3);
        tabs.setupWithViewPager(viewPager);
        return view;
    }

    private void setupViewPager(){
        PagerAdapter adapter = new PagerAdapter(getChildFragmentManager());
        adapter.addFragment(new MenuFragmentBuilder("today", "breakfast").build(), "Breakfast");
        adapter.addFragment(new MenuFragmentBuilder("today", "lunch").build(), "Lunch");
        adapter.addFragment(new MenuFragmentBuilder("today", "dinner").build(), "Dinner");
        viewPager.setAdapter(adapter);
    }

    private void setupToolbar(){
        toolbar.setTitle("North Dakota Dining");
    }

    private class PagerAdapter extends FragmentPagerAdapter{
        private final List<Fragment> fragmentList = new ArrayList<>();
        private final List<String> fragmentTitleList = new ArrayList<>();

        public PagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            fragmentList.add(fragment);
            fragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentTitleList.get(position);
        }
    }
}
