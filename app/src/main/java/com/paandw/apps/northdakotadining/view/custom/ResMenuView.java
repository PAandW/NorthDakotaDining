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

    public void setGrilleEntree(String entree){
        tvGrilleEntree.setText(entree);
    }

    public void setGrilleSides(String sides){
        tvGrilleSides.setText(sides);
    }

    public void setClassicsEntree(String entree){
        tvClassicsEntree.setText(entree);
    }

    public void setClassicsSides(String sides){
        tvClassicsSides.setText(sides);
    }

    public void setGlobalEntree(String entree){
        tvGlobalEntree.setText(entree);
    }

    public void setGlobalSides(String sides){
        tvGlobalSides.setText(sides);
    }

    public void setOptionsEntree(String entree){
        tvOptionsEntree.setText(entree);
    }

    public void setOptionsSides(String sides){
        tvOptionsSides.setText(sides);
    }

    public void setSoups(String soups){
        tvSoups.setText(soups);
    }

    public void setDesserts(String desserts){
        tvSoups.setText(desserts);
    }

    public void setOther(String other){
        tvOther.setText(other);
    }
}
