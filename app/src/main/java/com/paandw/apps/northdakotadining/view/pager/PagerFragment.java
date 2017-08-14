package com.paandw.apps.northdakotadining.view.pager;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.paandw.apps.northdakotadining.R;

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
        ButterKnife.bind(this, view);
        setupToolbar();

        tabs.setupWithViewPager(viewPager);
        return view;
    }

    private void setupViewPager(){

    }

    private void setupToolbar(){
        toolbar.setTitle("North Dakota Dining");
    }
}
