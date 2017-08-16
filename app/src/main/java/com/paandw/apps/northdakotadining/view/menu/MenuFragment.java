package com.paandw.apps.northdakotadining.view.menu;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.hannesdorfmann.fragmentargs.FragmentArgs;
import com.hannesdorfmann.fragmentargs.annotation.Arg;
import com.hannesdorfmann.fragmentargs.annotation.FragmentWithArgs;
import com.paandw.apps.northdakotadining.R;
import com.paandw.apps.northdakotadining.view.custom.ResMenuView;
import com.paandw.apps.northdakotadining.view.custom.UnionMenuView;
import com.paandw.apps.northdakotadining.view.custom.WestMenuView;

import butterknife.BindView;
import butterknife.ButterKnife;
import icepick.Icepick;
import me.zhanghai.android.materialprogressbar.MaterialProgressBar;

@FragmentWithArgs
public class MenuFragment extends Fragment implements IMenu{

    private MaterialDialog dialog;
    private MenuPresenter presenter;

    @Arg String date;
    @Arg String meal;

    @BindView(R.id.res_menu)
    ResMenuView resMenu;
    @BindView(R.id.res_progress_bar)
    MaterialProgressBar resProgressBar;
    @BindView(R.id.tv_res_empty_state)
    TextView tvResEmptyState;
    @BindView(R.id.west_menu)
    WestMenuView westMenu;
    @BindView(R.id.west_progress_bar)
    MaterialProgressBar westProgressBar;
    @BindView(R.id.tv_west_empty_state)
    TextView tvWestEmptyState;
    @BindView(R.id.union_menu)
    UnionMenuView unionMenu;
    @BindView(R.id.union_progress_bar)
    MaterialProgressBar unionProgressBar;
    @BindView(R.id.tv_union_empty_state)
    TextView tvUnionEmptyState;

    public MenuFragment() {
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
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        FragmentArgs.inject(this);
        ButterKnife.bind(this, view);
        presenter = new MenuPresenter(this, getContext());
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.start(date, meal);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Icepick.saveInstanceState(this, outState);
    }

    @Override
    public void showProgress(String message) {
        tvResEmptyState.setVisibility(View.GONE);
        tvWestEmptyState.setVisibility(View.GONE);
        tvUnionEmptyState.setVisibility(View.GONE);
        resMenu.setVisibility(View.GONE);
        westMenu.setVisibility(View.GONE);
        unionMenu.setVisibility(View.GONE);
        resProgressBar.setVisibility(View.VISIBLE);
        westProgressBar.setVisibility(View.VISIBLE);
        unionProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideResProgress() {
        resProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void hideWestProgress() {
        westProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void hideUnionProgress() {
        unionProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void setResData(SpannableStringBuilder grilleEntree, SpannableStringBuilder grilleSides,
                           SpannableStringBuilder classicsEntree, SpannableStringBuilder classicsSides,
                           SpannableStringBuilder globalEntree, SpannableStringBuilder globalSides,
                           SpannableStringBuilder optionsEntree, SpannableStringBuilder optionsSides,
                           SpannableStringBuilder soups, SpannableStringBuilder desserts, SpannableStringBuilder other) {
        boolean isEmpty = isEmptyCheck(grilleEntree, grilleSides, classicsEntree, classicsSides, globalEntree,
                globalSides, optionsEntree, optionsSides, soups, desserts, other);
        if(!isEmpty) {
            resMenu.setGrilleEntree(grilleEntree);
            resMenu.setGrilleSides(grilleSides);
            resMenu.setClassicsEntree(classicsEntree);
            resMenu.setClassicsSides(classicsSides);
            resMenu.setGlobalEntree(globalEntree);
            resMenu.setGlobalSides(globalSides);
            resMenu.setOptionsEntree(optionsEntree);
            resMenu.setOptionsSides(optionsSides);
            resMenu.setSoups(soups);
            resMenu.setDesserts(desserts);
            resMenu.setOther(other);
            resMenu.setVisibility(View.VISIBLE);
            tvResEmptyState.setVisibility(View.GONE);
        } else {
            resMenu.setVisibility(View.GONE);
            tvResEmptyState.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void setWestData(SpannableStringBuilder entrees, SpannableStringBuilder woodstone,
                            SpannableStringBuilder starches, SpannableStringBuilder vegetables,
                            SpannableStringBuilder soups, SpannableStringBuilder desserts, SpannableStringBuilder other) {
        boolean isEmpty = isEmptyCheck(entrees, woodstone, starches, vegetables, soups, desserts, other);
        if(!isEmpty) {
            westMenu.setEntrees(entrees);
            westMenu.setWoodstone(woodstone);
            westMenu.setStarches(starches);
            westMenu.setVegetables(vegetables);
            westMenu.setSoups(soups);
            westMenu.setDesserts(desserts);
            westMenu.setOther(other);
            westMenu.setVisibility(View.VISIBLE);
            tvWestEmptyState.setVisibility(View.GONE);
        } else {
            westMenu.setVisibility(View.GONE);
            tvWestEmptyState.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void setUnionData(SpannableStringBuilder entrees, SpannableStringBuilder starches,
                             SpannableStringBuilder vegetables, SpannableStringBuilder soups,
                             SpannableStringBuilder desserts, SpannableStringBuilder other) {
        boolean isEmpty = isEmptyCheck(entrees, starches, vegetables, soups, desserts, other);
        if(!isEmpty) {
            unionMenu.setEntrees(entrees);
            unionMenu.setStarches(starches);
            unionMenu.setVegetables(vegetables);
            unionMenu.setSoups(soups);
            unionMenu.setDesserts(desserts);
            unionMenu.setOther(other);
            unionMenu.setVisibility(View.VISIBLE);
            tvUnionEmptyState.setVisibility(View.GONE);
        } else {
            unionMenu.setVisibility(View.GONE);
            tvUnionEmptyState.setVisibility(View.VISIBLE);
        }
    }

    private boolean isEmptyCheck(SpannableStringBuilder... strings){
        boolean empty = true;
        for(SpannableStringBuilder string : strings){
            if(!TextUtils.isEmpty(string)){
                empty = false;
            }
        }
        return empty;
    }
}
