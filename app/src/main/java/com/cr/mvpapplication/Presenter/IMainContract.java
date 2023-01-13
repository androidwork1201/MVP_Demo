package com.cr.mvpapplication;

import com.cr.mvpapplication.View.BasePresenter;
import com.cr.mvpapplication.View.BaseView;

public interface IMainContract {
    interface View extends BaseView<Presenter> {
        void showProgress();
        void hideProgress();
        void showDrinkToUser(String drinkName);
    }

    interface Presenter extends BasePresenter {
        void suggestDrink();
    }
}
