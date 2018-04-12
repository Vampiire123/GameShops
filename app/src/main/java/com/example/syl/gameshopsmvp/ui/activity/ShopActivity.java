package com.example.syl.gameshopsmvp.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.syl.gameshopsmvp.R;
import com.example.syl.gameshopsmvp.global.model.Shop;
import com.example.syl.gameshopsmvp.ui.presenter.ShopPresenter;
import com.example.syl.gameshopsmvp.usecase.GetShops;

import java.util.List;

public class ShopActivity extends BaseActivity implements ShopPresenter.View {

    ShopPresenter shopPresenter;

    @Inject
    GetShops getShops;

    private void init() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();

        shopPresenter = new ShopPresenter(this, getShops);

        shopPresenter.setView(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_shop;
    }

    @Override
    public void showShops(List<Shop> shops) {

    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}