package com.paandw.apps.northdakotadining.view.menu;

import android.text.SpannableStringBuilder;

public interface IMenu {
    void showProgress(String message);
    void hideResProgress();
    void hideWestProgress();
    void hideUnionProgress();
    void setResData(SpannableStringBuilder grilleEntree, SpannableStringBuilder grilleSides, SpannableStringBuilder classicsEntree, SpannableStringBuilder classicsSides,
                    SpannableStringBuilder globalEntree, SpannableStringBuilder globalSides, SpannableStringBuilder optionsEntree,
                    SpannableStringBuilder optionsSides, SpannableStringBuilder soups, SpannableStringBuilder desserts, SpannableStringBuilder other);
    void setWestData(SpannableStringBuilder entrees, SpannableStringBuilder woodstone, SpannableStringBuilder starches,
                     SpannableStringBuilder vegetables, SpannableStringBuilder soups, SpannableStringBuilder desserts, SpannableStringBuilder other);
    void setUnionData(SpannableStringBuilder entrees, SpannableStringBuilder starches, SpannableStringBuilder vegetables,
                      SpannableStringBuilder soups, SpannableStringBuilder desserts, SpannableStringBuilder other);
}
