package com.paandw.apps.northdakotadining.view.custom;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.paandw.apps.northdakotadining.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WestMenuView extends LinearLayout {

    @BindView(R.id.tv_entrees_label)
    TextView tvEntreesLabel;
    @BindView(R.id.tv_entrees)
    TextView tvEntrees;
    @BindView(R.id.tv_woodstone_label)
    TextView tvWoodstoneLabel;
    @BindView(R.id.tv_woodstone)
    TextView tvWoodstone;
    @BindView(R.id.tv_starches_label)
    TextView tvStarchesLabel;
    @BindView(R.id.tv_starches)
    TextView tvStarches;
    @BindView(R.id.tv_vegetables_label)
    TextView tvVegetablesLabel;
    @BindView(R.id.tv_vegetables)
    TextView tvVegetables;
    @BindView(R.id.tv_soups_label)
    TextView tvSoupsLabel;
    @BindView(R.id.tv_soups)
    TextView tvSoups;
    @BindView(R.id.tv_desserts_label)
    TextView tvDessertsLabel;
    @BindView(R.id.tv_desserts)
    TextView tvDesserts;
    @BindView(R.id.tv_other_label)
    TextView tvOtherLabel;
    @BindView(R.id.tv_other)
    TextView tvOther;

    public WestMenuView(Context context) {
        super(context);
        setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        init();
    }

    public WestMenuView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){
        View view = inflate(getContext(), R.layout.view_west_menu, this);
        ButterKnife.bind(this, view);
    }

    public void setEntrees(String entrees){
        tvEntrees.setText(entrees);
    }

    public void setStarches(String starches){
        tvStarches.setText(starches);
    }

    public void setVegetables(String vegetables){
        tvVegetables.setText(vegetables);
    }

    public void setSoups(String soups){
        tvSoups.setText(soups);
    }

    public void setWoodstone(String woodstone){
        tvWoodstone.setText(woodstone);
    }

    public void setDesserts(String desserts){
        tvDesserts.setText(desserts);
    }

    public void setOther(String other){
        tvOther.setText(other);
    }
}
