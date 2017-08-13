package com.paandw.apps.northdakotadining.view.menu;

import android.text.SpannableStringBuilder;

import java.util.List;

public interface IMenu {
    void showProgress(String message);
    void hideProgress();
    void setResData(SpannableStringBuilder grilleEntree, SpannableStringBuilder grilleSides, SpannableStringBuilder classicsEntree, SpannableStringBuilder classicsSides,
                    SpannableStringBuilder globalEntree, SpannableStringBuilder globalSides, SpannableStringBuilder optionsEntree,
                    SpannableStringBuilder optionsSides, SpannableStringBuilder soups, SpannableStringBuilder desserts, SpannableStringBuilder other);
    void setWestData(List<String> data);
    void setUnionData(List<String> data);
}
