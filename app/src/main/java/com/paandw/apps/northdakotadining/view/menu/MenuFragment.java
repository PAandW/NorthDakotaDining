package com.paandw.apps.northdakotadining.view.menu;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.paandw.apps.northdakotadining.R;
import com.paandw.apps.northdakotadining.view.custom.ResMenuView;
import com.paandw.apps.northdakotadining.view.custom.UnionMenuView;
import com.paandw.apps.northdakotadining.view.custom.WestMenuView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MenuFragment extends Fragment implements IMenu{

    private MaterialDialog dialog;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_selected_date)
    TextView tvSelectedDate;
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
        ButterKnife.bind(this, view);
        toolbar.setTitle("North Dakota Dining");
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
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
    public void setWestData(List<String> data) {

    }

    @Override
    public void setUnionData(List<String> data) {

    }
}
