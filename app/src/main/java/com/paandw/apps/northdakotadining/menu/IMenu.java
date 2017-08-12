package com.paandw.apps.northdakotadining.menu;

import java.util.List;

public interface IMenu {
    void showProgress(String message);
    void hideProgress();
    void setResData(List<String> data);
    void setWestData(List<String> data);
    void setUnionData(List<String> data);
}
