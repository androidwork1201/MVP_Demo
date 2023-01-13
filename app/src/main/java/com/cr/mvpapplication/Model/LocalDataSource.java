package com.cr.mvpapplication.Model;

import com.cr.mvpapplication.Model.IDataSource;

import java.util.List;
import java.util.Random;

public class LocalDataSouce implements IDataSource {

    String[] drinksListLocal = {"What to drink"};

    @Override
    public void suggestNewDrink(LoadDataCallback callback) {
        try {

            String drinkName = drinksListLocal[new Random().nextInt(drinksListLocal.length)];
            callback.onDataLoaded(drinkName);
        } catch (Exception e) {
            callback.onDataNotAvailable(e);
        }
    }


    @Override
    public void addDrink(String drinkName) {

    }

}
