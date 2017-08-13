package com.paandw.apps.northdakotadining.view.custom;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.paandw.apps.northdakotadining.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UnionMenuView extends LinearLayout{

    @BindView(R.id.tv_entrees_label)
    TextView tvEntreesLabel;
    @BindView(R.id.tv_entrees)
    TextView tvEntrees;
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

    public UnionMenuView(Context context) {
        super(context);
        setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        init();
    }

    public UnionMenuView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){
        View view = inflate(getContext(), R.layout.view_union_menu, this);
        ButterKnife.bind(this, view);
    }

    public void setEntrees(SpannableStringBuilder entrees){
        if(entrees != null) {
            tvEntrees.setVisibility(View.VISIBLE);
            tvEntreesLabel.setVisibility(View.VISIBLE);
            tvEntrees.setText(entrees);
        } else {
            tvEntrees.setVisibility(View.INVISIBLE);
            tvEntreesLabel.setVisibility(View.INVISIBLE);
        }
    }

    public void setStarches(SpannableStringBuilder starches){
        if(starches != null) {
            tvStarches.setVisibility(View.VISIBLE);
            tvStarchesLabel.setVisibility(View.VISIBLE);
            tvStarches.setText(starches);
        } else {
            tvStarches.setVisibility(View.INVISIBLE);
            tvStarchesLabel.setVisibility(View.INVISIBLE);
        }
    }

    public void setVegetables(SpannableStringBuilder vegetables){
        if(vegetables != null) {
            tvVegetables.setVisibility(View.VISIBLE);
            tvVegetablesLabel.setVisibility(View.VISIBLE);
            tvVegetables.setText(vegetables);
        } else {
            tvVegetables.setVisibility(View.INVISIBLE);
            tvVegetablesLabel.setVisibility(View.INVISIBLE);
        }
    }

    public void setSoups(SpannableStringBuilder soups){
        if(soups != null) {
            tvSoups.setVisibility(View.VISIBLE);
            tvSoupsLabel.setVisibility(View.VISIBLE);
            tvSoups.setText(soups);
        } else {
            tvSoups.setVisibility(View.INVISIBLE);
            tvSoupsLabel.setVisibility(View.INVISIBLE);
        }
    }

    public void setDesserts(SpannableStringBuilder desserts){
        if(desserts != null) {
            tvDesserts.setVisibility(View.VISIBLE);
            tvDessertsLabel.setVisibility(View.VISIBLE);
            tvDesserts.setText(desserts);
        } else {
            tvDesserts.setVisibility(View.INVISIBLE);
            tvDessertsLabel.setVisibility(View.INVISIBLE);
        }
    }

    public void setOther(SpannableStringBuilder other){
        if(other != null) {
            tvOther.setVisibility(View.VISIBLE);
            tvOtherLabel.setVisibility(View.VISIBLE);
            tvOther.setText(other);
        } else {
            tvOther.setVisibility(View.INVISIBLE);
            tvOtherLabel.setVisibility(View.INVISIBLE);
        }
    }
}
