package com.example.syl.gameshopsmvp.ui.presenter;

import android.content.Context;

import com.example.syl.gameshopsmvp.global.model.Shop;
import com.example.syl.gameshopsmvp.usecase.GetShops;

import java.util.List;

public class ShopPresenter extends Presenter<ShopPresenter.View> {

    protected Context context;

    protected GetShops getShops;

    @Inject
    public ShopPresenter(Context ctx, GetShops getShops) {
        this.context = ctx;
        this.getShops = getShops;
    }

    @Override
    public void initialize() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }

    public interface View {
        void showShops(List<Shop> shops);

        void showError(String message);
    }
}