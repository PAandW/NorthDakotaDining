package com.paandw.apps.northdakotadining.view.menu;

import java.util.ArrayList;
import java.util.List;

public class MenuPresenter {
    private IMenu view;
    private List<String> resGrilleEntree, resGrilleSides, resClassicsEntree, resClassicsSides,
        resGlobalEntree, resGlobalSides, resOptionsEntree, resOptionsSides, resSoups, resDesserts, resOther;
    private List<String> westEntrees, westWoodstone, westStarches, westVegetables, westSoups, westDesserts, westOther;
    private List<String> unionEntrees, unionStarches, unionVegetables, unionSoups, unionDesserts, unionOther;


    public MenuPresenter(IMenu view){
        this.view = view;
    }

    public void start(String date, String meal){
        initializeMenuLists();
        view.showProgress("Loading");
        //TODO show progress dialog and get data
    }

    private void initializeMenuLists(){
        resGrilleEntree = new ArrayList<>();
        resGrilleSides = new ArrayList<>();
        resClassicsEntree = new ArrayList<>();
        resClassicsSides = new ArrayList<>();
        resGlobalEntree = new ArrayList<>();
        resGlobalSides = new ArrayList<>();
        resOptionsEntree = new ArrayList<>();
        resOptionsSides = new ArrayList<>();
        resSoups = new ArrayList<>();
        resDesserts = new ArrayList<>();
        resOther = new ArrayList<>();

        westEntrees = new ArrayList<>();
        westWoodstone = new ArrayList<>();
        westStarches = new ArrayList<>();
        westVegetables = new ArrayList<>();
        westSoups = new ArrayList<>();
        westDesserts = new ArrayList<>();
        westOther = new ArrayList<>();

        unionEntrees = new ArrayList<>();
        unionStarches = new ArrayList<>();
        unionVegetables = new ArrayList<>();
        unionSoups = new ArrayList<>();
        unionDesserts = new ArrayList<>();
        unionOther = new ArrayList<>();
    }
}
