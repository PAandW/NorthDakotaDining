package com.paandw.apps.northdakotadining.view.menu;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

@FragmentWithArgs
public class MenuFragment extends Fragment implements IMenu{

    private MaterialDialog dialog;
    private MenuPresenter presenter;

    @Arg String date;
    @Arg String meal;

    @BindView(R.id.res_menu)
    ResMenuView resMenu;
    @BindView(R.id.west_menu)
    WestMenuView westMenu;
    @BindView(R.id.union_menu)
    UnionMenuView unionMenu;

    public MenuFragment() {
        // Required empty public constructor
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
    public void showProgress(String message) {
        if(dialog != null){
            dialog.setContent(message);
        } else {
            dialog = new MaterialDialog.Builder(getActivity())
                    .content(message)
                    .progress(true, 0)
                    .build();
        }
        dialog.show();
    }

    @Override
    public void hideProgress() {
        dialog.dismiss();
    }

    @Override
    public void setResData(SpannableStringBuilder grilleEntree, SpannableStringBuilder grilleSides,
                           SpannableStringBuilder classicsEntree, SpannableStringBuilder classicsSides,
                           SpannableStringBuilder globalEntree, SpannableStringBuilder globalSides,
                           SpannableStringBuilder optionsEntree, SpannableStringBuilder optionsSides,
                           SpannableStringBuilder soups, SpannableStringBuilder desserts, SpannableStringBuilder other) {

    }

    @Override
    public void setWestData(SpannableStringBuilder entrees, SpannableStringBuilder woodstone,
                            SpannableStringBuilder starches, SpannableStringBuilder vegetables,
                            SpannableStringBuilder soups, SpannableStringBuilder desserts, SpannableStringBuilder other) {
        westMenu.setEntrees(entrees);
        westMenu.setWoodstone(woodstone);
        westMenu.setStarches(starches);
        westMenu.setVegetables(vegetables);
        westMenu.setSoups(soups);
        westMenu.setDesserts(desserts);
        westMenu.setOther(other);
    }

    @Override
    public void setUnionData(SpannableStringBuilder entrees, SpannableStringBuilder starches,
                             SpannableStringBuilder vegetables, SpannableStringBuilder soups,
                             SpannableStringBuilder desserts, SpannableStringBuilder other) {

    }
}
