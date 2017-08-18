package com.paandw.apps.northdakotadining.view.pager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hannesdorfmann.fragmentargs.FragmentArgs;
import com.jakewharton.threetenabp.AndroidThreeTen;
import com.paandw.apps.northdakotadining.R;
import com.paandw.apps.northdakotadining.util.FormatUtil;
import com.paandw.apps.northdakotadining.view.menu.MenuFragmentBuilder;

import org.threeten.bp.LocalDateTime;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import icepick.Icepick;

public class PagerFragment extends Fragment {

    private Menu menu;
    private final SimpleDateFormat MAIN_FORMATTER = new SimpleDateFormat("EEEE, MMMM dd", Locale.US);
    private final SimpleDateFormat MENU_FORMATTER = new SimpleDateFormat("EEE, MMM dd", Locale.US);

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
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(savedInstanceState != null){
            Icepick.restoreInstanceState(this, savedInstanceState);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pager, container, false);
        FragmentArgs.inject(this);
        ButterKnife.bind(this, view);
        AndroidThreeTen.init(getContext());
        setupToolbar();
        LocalDateTime now = LocalDateTime.now();
        String today = FormatUtil.getSelectedDateText(now);
        tvSelectedDate.setText(today);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupViewPager();
        viewPager.setOffscreenPageLimit(3);
        viewPager.setCurrentItem(1);
        tabs.setupWithViewPager(viewPager);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Icepick.saveInstanceState(this, outState);
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
        toolbar.inflateMenu(R.menu.date_picker_menu);
        List<String> dateList = new ArrayList<>();
        for(int i = 1; i < 10; i++){
            LocalDateTime date = LocalDateTime.now().plusDays(i);
            dateList.add(FormatUtil.getMenuDateText(date));
        }
        for(int i = 1; i < 10; i++){
            if(toolbar.getMenu().getItem(i).getTitle().equals("Date " + i)){
                toolbar.getMenu().getItem(i).setTitle(dateList.get(i-1));
            }
        }
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
