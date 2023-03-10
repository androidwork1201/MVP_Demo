package com.cr.mvpapplication;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RemoteDataSource implements IDataSource{
    String[] drinksListRemote = {"Milk", "Coffee", "Orange juice", "Cola", "Red tea"};

    @Override
    public void suggestNewDrink(LoadDataCallback callback) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {


                try {
                    Thread.sleep(1000); // Mimic server request / long execution

                    String drinkName = drinksListRemote[new Random().nextInt(drinksListRemote.length)];
                    callback.onDataLoaded(drinkName);

                } catch (InterruptedException e) {
                    callback.onDataNotAvailable(e);
                } catch (Exception e){
                    callback.onDataNotAvailable(e);
                }
            }
        });
    }

    @Override
    public void deleteAllDrinks() {

    }

    @Override
    public void deleteDrink(String drinkName) {

    }

    @Override
    public void addDrink(String drinkName) {

    }

    @Override
    public void addDrinks(List<String> drinks) {

    }
}
