package com.example.syl.gameshopsmvp.ui.presenter;

import android.content.Context;

import com.example.syl.gameshopsmvp.global.model.Shop;
import com.example.syl.gameshopsmvp.usecase.GetShops;

import java.util.List;

public class ShopPresenter extends Presenter<ShopPresenter.View> {

    protected Context context;

    protected GetShops getShops;

    public ShopPresenter(Context ctx, GetShops getShops) {
        this.context = ctx;
        this.getShops = getShops;
    }

    @Override
    public void initialize() {
        getShops.getShops(new GetShops.Listener() {
            @Override
            public void onSuccess(List<Shop> shops) {
                view.showShops(shops);
            }

            @Override
            public void onError(String message) {
                view.showError(message);
            }
        });
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

    public void onShopClicked(Shop shop) {
        view.showShop(shop);
    }

    public interface View {
        void showShops(List<Shop> shops);
        void showShop(Shop shop);
        void showError(String message);
    }
}