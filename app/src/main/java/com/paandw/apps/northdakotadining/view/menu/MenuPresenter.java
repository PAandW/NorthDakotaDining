package com.paandw.apps.northdakotadining.view.menu;

import android.content.Context;
import android.os.AsyncTask;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;

import com.paandw.apps.northdakotadining.R;
import com.paandw.apps.northdakotadining.util.FormatUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MenuPresenter {
    private IMenu view;
    private Context context;
    private String meal;
    private List<String> unionEntrees, unionStarches, unionVegetables, unionSoups, unionDesserts, unionOther;


    public MenuPresenter(IMenu view, Context context){
        this.view = view;
        this.context = context;
    }

    public void start(String date, String meal){
        this.meal = meal;
        initializeMenuLists();
        view.showProgress("Loading");
        //TODO show progress dialog and get data
    }

    private void initializeMenuLists(){
        unionEntrees = new ArrayList<>();
        unionStarches = new ArrayList<>();
        unionVegetables = new ArrayList<>();
        unionSoups = new ArrayList<>();
        unionDesserts = new ArrayList<>();
        unionOther = new ArrayList<>();
    }

    private class ResMenuDownloader extends AsyncTask<String, Void, Void>{

        private List<String> grilleEntree, grilleSides, classicsEntree, classicsSides,
                globalEntree, globalSides, optionsEntree, optionsSides, soups, desserts, other;
        private List<String> grilleEntreeNutrition, grilleSidesNutrition, classicsEntreeNutrition, classicsSidesNutrition,
                globalEntreeNutrition, globalSidesNutrition, optionsEntreeNutrition, optionsSidesNutrition, soupsNutrition,
                dessertsNutrition, otherNutrition;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            grilleEntree = new ArrayList<>();
            grilleSides = new ArrayList<>();
            classicsEntree = new ArrayList<>();
            classicsSides = new ArrayList<>();
            globalEntree = new ArrayList<>();
            globalSides = new ArrayList<>();
            optionsEntree = new ArrayList<>();
            optionsSides = new ArrayList<>();
            soups = new ArrayList<>();
            desserts = new ArrayList<>();
            other = new ArrayList<>();

            grilleEntreeNutrition = new ArrayList<>();
            grilleSidesNutrition = new ArrayList<>();
            classicsEntreeNutrition = new ArrayList<>();
            classicsSidesNutrition = new ArrayList<>();
            globalEntreeNutrition = new ArrayList<>();
            globalSidesNutrition = new ArrayList<>();
            optionsEntreeNutrition = new ArrayList<>();
            optionsSidesNutrition = new ArrayList<>();
            soupsNutrition = new ArrayList<>();
            dessertsNutrition = new ArrayList<>();
            otherNutrition = new ArrayList<>();
        }

        @Override
        protected Void doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);

                BufferedReader htmlStream = new BufferedReader(new InputStreamReader(url.openStream()));
                String line;



            } catch (IOException e) {
                //Do nothing
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }

    private class WestMenuDownloader extends AsyncTask<String, Void, Void>{

        private List<String> entrees, woodstone, starches, vegetables, soups, desserts, other;
        private List<String> entreesNutrition, woodstoneNutrition, starchesNutrition, vegetablesNutrition, soupsNutrition, dessertsNutrition, otherNutrition;
        private SpannableStringBuilder entreesBuilder, woodstoneBuilder, starchesBuilder, vegetablesBuilder, soupsBuilder, dessertsBuilder, otherBuilder;
        private boolean isMeal, isEntree, isWoodstone, isStarches, isVegetables, isSoups, isDesserts, isOther;
        private String nutritionGraphicHandler;

        @Override
        protected void onPreExecute() {
            entrees = new ArrayList<>();
            woodstone = new ArrayList<>();
            starches = new ArrayList<>();
            vegetables = new ArrayList<>();
            soups = new ArrayList<>();
            desserts = new ArrayList<>();
            other = new ArrayList<>();

            entreesNutrition = new ArrayList<>();
            woodstoneNutrition = new ArrayList<>();
            starchesNutrition = new ArrayList<>();
            vegetablesNutrition = new ArrayList<>();
            soupsNutrition = new ArrayList<>();
            dessertsNutrition = new ArrayList<>();
            otherNutrition = new ArrayList<>();

            entreesBuilder = new SpannableStringBuilder();
            woodstoneBuilder = new SpannableStringBuilder();
            starchesBuilder = new SpannableStringBuilder();
            vegetablesBuilder = new SpannableStringBuilder();
            soupsBuilder = new SpannableStringBuilder();
            dessertsBuilder = new SpannableStringBuilder();
            otherBuilder = new SpannableStringBuilder();

            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(String... strings) {
            try{
                URL url = new URL(strings[0]);
                BufferedReader htlmStream = new BufferedReader(new InputStreamReader(url.openStream()));
                String line;

                while((line = htlmStream.readLine()) != null){
                    if(line.contains("shortmenumeals") && line.toLowerCase().contains(meal)){
                        isMeal = true;
                    } else {
                        isMeal = false;
                    }

                    if(isMeal) {
                        setMealCategory(line);
                        getMenuData(line);
                    }
                }


            } catch(IOException exception){
                //Do nothing
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

        }

        private void setMealCategory(String line){
            if(line.toLowerCase().contains("dessert")) {
                isDesserts = true;
                isEntree = false;
                isSoups = false;
                isStarches = false;
                isVegetables = false;
                isWoodstone = false;
                isOther = false;
            } else if(line.toLowerCase().contains("entree")){
                isDesserts = false;
                isEntree = true;
                isSoups = false;
                isStarches = false;
                isVegetables = false;
                isWoodstone = false;
                isOther = false;
            } else if(line.toLowerCase().contains("soups/chowder")){
                isDesserts = false;
                isEntree = false;
                isSoups = true;
                isStarches = false;
                isVegetables = false;
                isWoodstone = false;
                isOther = false;
            } else if(line.toLowerCase().contains("woodstone")){
                isDesserts = false;
                isEntree = false;
                isSoups = false;
                isStarches = false;
                isVegetables = false;
                isWoodstone = true;
                isOther = false;
            } else if(line.toLowerCase().contains("starches")){
                isDesserts = false;
                isEntree = false;
                isSoups = false;
                isStarches = true;
                isVegetables = false;
                isWoodstone = false;
                isOther = false;
            } else if(line.toLowerCase().contains("vegetables")){
                isDesserts = false;
                isEntree = false;
                isSoups = false;
                isStarches = false;
                isVegetables = true;
                isWoodstone = false;
                isOther = false;
            } else if(line.toLowerCase().contains("shortmenucats")){
                isDesserts = false;
                isEntree = false;
                isSoups = false;
                isStarches = false;
                isVegetables = false;
                isWoodstone = false;
                isOther = true;
            }
        }
        private void getMenuData(String line){
            if(line.contains("shortmenurecipes")){
                line = FormatUtil.stripHTML(line);
                if(isEntree){
                    entrees.add(line);
                } else if(isWoodstone){
                    woodstone.add(line);
                } else if(isStarches){
                    starches.add(line);
                } else if(isVegetables){
                    vegetables.add(line);
                } else if(isSoups){
                    soups.add(line);
                } else if(isDesserts){
                    desserts.add(line);
                } else if(isOther){
                    other.add(line);
                }
            } else if(line.contains("LegendImages")){
                if(line.contains("veggie")){
                    nutritionGraphicHandler += "*veggie*";
                } else if(line.contains("gluten")){
                    nutritionGraphicHandler += "*gluten*";
                } else if(line.contains("nuts")){
                    nutritionGraphicHandler += "*nuts*";
                } else if(line.contains("trn")){
                    nutritionGraphicHandler += "*trace*";
                }
            }

            if(line.contains("shortmenuprices")){
                if(isEntree){
                    entreesNutrition.add(nutritionGraphicHandler);
                    nutritionGraphicHandler = "";
                } else if(isWoodstone){
                    woodstoneNutrition.add(nutritionGraphicHandler);
                    nutritionGraphicHandler = "";
                } else if(isStarches){
                    starchesNutrition.add(nutritionGraphicHandler);
                    nutritionGraphicHandler = "";
                } else if(isVegetables){
                    vegetablesNutrition.add(nutritionGraphicHandler);
                    nutritionGraphicHandler = "";
                } else if(isSoups){
                    soupsNutrition.add(nutritionGraphicHandler);
                    nutritionGraphicHandler = "";
                } else if(isDesserts){
                    dessertsNutrition.add(nutritionGraphicHandler);
                    nutritionGraphicHandler = "";
                } else if(isOther){
                    otherNutrition.add(nutritionGraphicHandler);
                    nutritionGraphicHandler = "";
                }
            }
        }
        private void mergeMealData(){
            ImageSpan glutenImage = new ImageSpan(context, R.drawable.gluten);
            ImageSpan nutsImage = new ImageSpan(context, R.drawable.nuts);
            ImageSpan trnImage = new ImageSpan(context, R.drawable.trn);
            ImageSpan veggieImage = new ImageSpan(context, R.drawable.veggie);
        }
    }
}
