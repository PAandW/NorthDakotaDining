package com.paandw.apps.northdakotadining.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.v4.content.ContextCompat;
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

    private final String defaultResURL = "https://www.ndsu.edu/dining/menu/shortmenu.asp?sName=MENUS+ON+THE+WEB&locationNum=04&locationName=Residence+Dining+Center&naFlag=1";
    private final String defaultWestURL = "https://www.ndsu.edu/dining/menu/shortmenu.asp?sName=MENUS+ON+THE+WEB&locationNum=02&locationName=West+Dining+Center&naFlag=1";
    private final String defaultUnionURL = "https://www.ndsu.edu/dining/menu/shortmenu.asp?sName=MENUS+ON+THE+WEB&locationNum=10&locationName=Union+Dining+Center&naFlag=1";


    public MenuPresenter(IMenu view, Context context){
        this.view = view;
        this.context = context;
    }

    public void start(String date, String meal){
        this.meal = meal;
        initializeMenuLists();
        view.showProgress("Loading");

        if(date.equalsIgnoreCase("today")) {
            new WestMenuDownloader().execute(defaultWestURL);
            new UnionMenuDownloader().execute(defaultUnionURL);
        }
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
                    } else if(line.contains("shortmenumeals")){
                        isMeal = false;
                    }

                    if(isMeal) {
                        setMealCategory(line);
                        getMenuData(line);
                    }
                }
                htlmStream.close();

                mergeMealData(entreesBuilder, entrees, entreesNutrition);
                mergeMealData(woodstoneBuilder, woodstone, woodstoneNutrition);
                mergeMealData(starchesBuilder, starches, starchesNutrition);
                mergeMealData(vegetablesBuilder, vegetables, vegetablesNutrition);
                mergeMealData(soupsBuilder, soups, soupsNutrition);
                mergeMealData(dessertsBuilder, desserts, dessertsNutrition);
                mergeMealData(otherBuilder, other, otherNutrition);

            } catch(IOException exception){
                //Do nothing
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            view.setWestData(entreesBuilder, woodstoneBuilder, starchesBuilder, vegetablesBuilder,
                    soupsBuilder, dessertsBuilder, otherBuilder);
            view.hideWestProgress();
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
                line = FormatUtil.stripHTML(line).trim();
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
                    nutritionGraphicHandler += "veggie";
                } else if(line.contains("gluten")){
                    nutritionGraphicHandler += "gluten";
                } else if(line.contains("nuts")){
                    nutritionGraphicHandler += "nuts";
                } else if(line.contains("trn")){
                    nutritionGraphicHandler += "trn";
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
        private void mergeMealData(SpannableStringBuilder builder, List<String> menuItems, List<String> nutritionItems){
            int scale = (int)(16 * context.getResources().getDisplayMetrics().scaledDensity);
            Drawable glutenDrawable = ContextCompat.getDrawable(context, R.drawable.gluten);
            glutenDrawable.setBounds(0, 0, scale, scale);

            Drawable veggieDrawable = ContextCompat.getDrawable(context, R.drawable.veggie);
            veggieDrawable.setBounds(0, 0, scale, scale);

            Drawable nutsDrawable = ContextCompat.getDrawable(context, R.drawable.nuts);
            nutsDrawable.setBounds(0, 0, scale, scale);

            Drawable trnDrawable = ContextCompat.getDrawable(context, R.drawable.trn);
            trnDrawable.setBounds(0, 0, scale, scale);

            for (int i = 0; i < menuItems.size(); i++){
                SpannableStringBuilder glutenImage = new SpannableStringBuilder("   ");
                glutenImage.setSpan(new ImageSpan(glutenDrawable), 1, 2, 12);

                SpannableStringBuilder veggieImage = new SpannableStringBuilder("   ");
                veggieImage.setSpan(new ImageSpan(veggieDrawable), 1, 2, 12);

                SpannableStringBuilder nutsImage = new SpannableStringBuilder("   ");
                nutsImage.setSpan(new ImageSpan(nutsDrawable), 1, 2, 12);

                SpannableStringBuilder trnImage = new SpannableStringBuilder("   ");
                trnImage.setSpan(new ImageSpan(trnDrawable), 1, 2, 12);

                builder.append(menuItems.get(i));
                String nutrition = nutritionItems.get(i);
                if(nutrition.contains("veggie")){
                    builder.append(veggieImage);
                }
                if(nutrition.contains("gluten")){
                    builder.append(glutenImage);
                }
                if(nutrition.contains("nuts")){
                    builder.append(nutsImage);
                }
                if(nutrition.contains("trn")){
                    builder.append(trnImage);
                }

                if(i != menuItems.size() - 1){
                    builder.append(", ");
                }
            }

        }
    }

    private class UnionMenuDownloader extends AsyncTask<String, Void, Void>{

        private List<String> entrees, starches, vegetables, soups, desserts, other;
        private List<String> entreesNutrition, starchesNutrition, vegetablesNutrition, soupsNutrition, dessertsNutrition, otherNutrition;
        private SpannableStringBuilder entreesBuilder, starchesBuilder, vegetablesBuilder, soupsBuilder, dessertsBuilder, otherBuilder;
        private boolean isMeal, isEntree, isStarches, isVegetables, isSoups, isDesserts, isOther;
        private String nutritionGraphicHandler;

        @Override
        protected void onPreExecute() {
            entrees = new ArrayList<>();
            starches = new ArrayList<>();
            vegetables = new ArrayList<>();
            soups = new ArrayList<>();
            desserts = new ArrayList<>();
            other = new ArrayList<>();

            entreesNutrition = new ArrayList<>();
            starchesNutrition = new ArrayList<>();
            vegetablesNutrition = new ArrayList<>();
            soupsNutrition = new ArrayList<>();
            dessertsNutrition = new ArrayList<>();
            otherNutrition = new ArrayList<>();

            entreesBuilder = new SpannableStringBuilder();
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
                    } else if(line.contains("shortmenumeals")){
                        isMeal = false;
                    }

                    if(isMeal) {
                        setMealCategory(line);
                        getMenuData(line);
                    }
                }
                htlmStream.close();

                mergeMealData(entreesBuilder, entrees, entreesNutrition);
                mergeMealData(starchesBuilder, starches, starchesNutrition);
                mergeMealData(vegetablesBuilder, vegetables, vegetablesNutrition);
                mergeMealData(soupsBuilder, soups, soupsNutrition);
                mergeMealData(dessertsBuilder, desserts, dessertsNutrition);
                mergeMealData(otherBuilder, other, otherNutrition);

            } catch(IOException exception){
                //Do nothing
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            view.setUnionData(entreesBuilder, starchesBuilder, vegetablesBuilder,
                    soupsBuilder, dessertsBuilder, otherBuilder);
            view.hideUnionProgress();
        }

        private void setMealCategory(String line){
            if(line.toLowerCase().contains("dessert")) {
                isDesserts = true;
                isEntree = false;
                isSoups = false;
                isStarches = false;
                isVegetables = false;
                isOther = false;
            } else if(line.toLowerCase().contains("entree")){
                isDesserts = false;
                isEntree = true;
                isSoups = false;
                isStarches = false;
                isVegetables = false;
                isOther = false;
            } else if(line.toLowerCase().contains("soups/chowder")){
                isDesserts = false;
                isEntree = false;
                isSoups = true;
                isStarches = false;
                isVegetables = false;
                isOther = false;
            } else if(line.toLowerCase().contains("starches")){
                isDesserts = false;
                isEntree = false;
                isSoups = false;
                isStarches = true;
                isVegetables = false;
                isOther = false;
            } else if(line.toLowerCase().contains("vegetables")){
                isDesserts = false;
                isEntree = false;
                isSoups = false;
                isStarches = false;
                isVegetables = true;
                isOther = false;
            } else if(line.toLowerCase().contains("shortmenucats")){
                isDesserts = false;
                isEntree = false;
                isSoups = false;
                isStarches = false;
                isVegetables = false;
                isOther = true;
            }
        }
        private void getMenuData(String line){
            if(line.contains("shortmenurecipes")){
                line = FormatUtil.stripHTML(line).trim();
                if(isEntree){
                    entrees.add(line);
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
                    nutritionGraphicHandler += "veggie";
                } else if(line.contains("gluten")){
                    nutritionGraphicHandler += "gluten";
                } else if(line.contains("nuts")){
                    nutritionGraphicHandler += "nuts";
                } else if(line.contains("trn")){
                    nutritionGraphicHandler += "trn";
                }
            }

            if(line.contains("shortmenuprices")){
                if(isEntree){
                    entreesNutrition.add(nutritionGraphicHandler);
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
        private void mergeMealData(SpannableStringBuilder builder, List<String> menuItems, List<String> nutritionItems){
            int scale = (int)(16 * context.getResources().getDisplayMetrics().scaledDensity);
            Drawable glutenDrawable = ContextCompat.getDrawable(context, R.drawable.gluten);
            glutenDrawable.setBounds(0, 0, scale, scale);

            Drawable veggieDrawable = ContextCompat.getDrawable(context, R.drawable.veggie);
            veggieDrawable.setBounds(0, 0, scale, scale);

            Drawable nutsDrawable = ContextCompat.getDrawable(context, R.drawable.nuts);
            nutsDrawable.setBounds(0, 0, scale, scale);

            Drawable trnDrawable = ContextCompat.getDrawable(context, R.drawable.trn);
            trnDrawable.setBounds(0, 0, scale, scale);

            for (int i = 0; i < menuItems.size(); i++){
                SpannableStringBuilder glutenImage = new SpannableStringBuilder("   ");
                glutenImage.setSpan(new ImageSpan(glutenDrawable), 1, 2, 12);

                SpannableStringBuilder veggieImage = new SpannableStringBuilder("   ");
                veggieImage.setSpan(new ImageSpan(veggieDrawable), 1, 2, 12);

                SpannableStringBuilder nutsImage = new SpannableStringBuilder("   ");
                nutsImage.setSpan(new ImageSpan(nutsDrawable), 1, 2, 12);

                SpannableStringBuilder trnImage = new SpannableStringBuilder("   ");
                trnImage.setSpan(new ImageSpan(trnDrawable), 1, 2, 12);

                builder.append(menuItems.get(i));
                String nutrition = nutritionItems.get(i);
                if(nutrition.contains("veggie")){
                    builder.append(veggieImage);
                }
                if(nutrition.contains("gluten")){
                    builder.append(glutenImage);
                }
                if(nutrition.contains("nuts")){
                    builder.append(nutsImage);
                }
                if(nutrition.contains("trn")){
                    builder.append(trnImage);
                }

                if(i != menuItems.size() - 1){
                    builder.append(", ");
                }
            }

        }
    }
}
