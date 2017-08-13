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

public class ResMenuView extends LinearLayout{

    @BindView(R.id.tv_grille_entree_label)
    TextView tvGrilleEntreeLabel;
    @BindView(R.id.tv_grille_sides_label)
    TextView tvGrilleSidesLabel;
    @BindView(R.id.tv_grille_sides)
    TextView tvGrilleSides;
    @BindView(R.id.tv_grille_entree)
    TextView tvGrilleEntree;
    @BindView(R.id.tv_classics_entree_label)
    TextView tvClassicsEntreeLabel;
    @BindView(R.id.tv_classics_entree)
    TextView tvClassicsEntree;
    @BindView(R.id.tv_classics_sides_label)
    TextView tvClassicsSidesLabel;
    @BindView(R.id.tv_classics_sides)
    TextView tvClassicsSides;
    @BindView(R.id.tv_global_entree_label)
    TextView tvGlobalEntreeLabel;
    @BindView(R.id.tv_global_entree)
    TextView tvGlobalEntree;
    @BindView(R.id.tv_global_sides_label)
    TextView tvGlobalSidesLabel;
    @BindView(R.id.tv_global_sides)
    TextView tvGlobalSides;
    @BindView(R.id.tv_options_entree_label)
    TextView tvOptionsEntreeLabel;
    @BindView(R.id.tv_options_entree)
    TextView tvOptionsEntree;
    @BindView(R.id.tv_options_sides_label)
    TextView tvOptionsSidesLabel;
    @BindView(R.id.tv_options_sides)
    TextView tvOptionsSides;
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

    public ResMenuView(Context context) {
        super(context);
        setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        init();
    }

    public ResMenuView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        View view = inflate(getContext(), R.layout.view_res_menu, this);
        ButterKnife.bind(this, view);
    }

    public void setGrilleEntree(SpannableStringBuilder entree){
        if(entree != null) {
            tvGrilleEntree.setVisibility(View.VISIBLE);
            tvGrilleEntreeLabel.setVisibility(View.VISIBLE);
            tvGrilleEntree.setText(entree);
        } else {
            tvGrilleEntree.setVisibility(View.INVISIBLE);
            tvGrilleEntreeLabel.setVisibility(View.INVISIBLE);
        }
    }

    public void setGrilleSides(SpannableStringBuilder sides){
        if(sides != null) {
            tvGrilleSides.setVisibility(View.VISIBLE);
            tvGrilleSidesLabel.setVisibility(View.VISIBLE);
            tvGrilleSides.setText(sides);
        } else {
            tvGrilleSides.setVisibility(View.INVISIBLE);
            tvGrilleSidesLabel.setVisibility(View.INVISIBLE);
        }
    }

    public void setClassicsEntree(SpannableStringBuilder entree){
        if(entree != null) {
            tvClassicsEntree.setVisibility(View.VISIBLE);
            tvClassicsEntreeLabel.setVisibility(View.VISIBLE);
            tvClassicsEntree.setText(entree);
        } else {
            tvClassicsEntree.setVisibility(View.INVISIBLE);
            tvClassicsEntreeLabel.setVisibility(View.INVISIBLE);
        }
    }

    public void setClassicsSides(SpannableStringBuilder sides){
        if(sides != null) {
            tvClassicsSides.setVisibility(View.VISIBLE);
            tvClassicsSidesLabel.setVisibility(View.VISIBLE);
            tvClassicsSides.setText(sides);
        } else {
            tvClassicsSides.setVisibility(View.INVISIBLE);
            tvClassicsSidesLabel.setVisibility(View.INVISIBLE);
        }
    }

    public void setGlobalEntree(SpannableStringBuilder entree){
        if(entree != null) {
            tvGlobalEntree.setVisibility(View.VISIBLE);
            tvGlobalEntreeLabel.setVisibility(View.VISIBLE);
            tvGlobalEntree.setText(entree);
        } else {
            tvGlobalEntree.setVisibility(View.INVISIBLE);
            tvGlobalEntreeLabel.setVisibility(View.INVISIBLE);
        }
    }

    public void setGlobalSides(SpannableStringBuilder sides){
        if(sides != null) {
            tvGlobalSides.setVisibility(View.VISIBLE);
            tvGlobalSidesLabel.setVisibility(View.VISIBLE);
            tvGlobalSides.setText(sides);
        } else {
            tvGlobalSides.setVisibility(View.INVISIBLE);
            tvGlobalSidesLabel.setVisibility(View.INVISIBLE);
        }
    }

    public void setOptionsEntree(SpannableStringBuilder entree){
        if(entree != null) {
            tvOptionsEntree.setVisibility(View.VISIBLE);
            tvOptionsEntreeLabel.setVisibility(View.VISIBLE);
            tvOptionsEntree.setText(entree);
        } else {
            tvOptionsEntree.setVisibility(View.INVISIBLE);
            tvOptionsEntreeLabel.setVisibility(View.INVISIBLE);
        }
    }

    public void setOptionsSides(SpannableStringBuilder sides){
        if(sides != null) {
            tvOptionsSides.setVisibility(View.VISIBLE);
            tvOptionsSidesLabel.setVisibility(View.VISIBLE);
            tvOptionsSides.setText(sides);
        } else {
            tvOptionsSides.setVisibility(View.INVISIBLE);
            tvOptionsSidesLabel.setVisibility(View.INVISIBLE);
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
