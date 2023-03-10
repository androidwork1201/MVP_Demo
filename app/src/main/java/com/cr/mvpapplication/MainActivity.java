package com.cr.mvpapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements IMainContract.View {

    TextView tvDrinkName;
    ProgressBar progressBar;
    Button bGetDrink;

    IMainContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDrinkName = findViewById(R.id.text_result);
        progressBar = findViewById(R.id.progressBar);
        bGetDrink = findViewById(R.id.btn_get_answer);

        presenter = new MainPresenter(new MainRepository(
                new RemoteDataSource(),
                new LocalDataSouce()
        ),this);

        bGetDrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.suggestDrink();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.start();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showDrinkToUser(String drinkName) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tvDrinkName.setText(drinkName);
            }
        });
    }

    @Override
    public void setPresenter(IMainContract.Presenter presenter) {

    }
}