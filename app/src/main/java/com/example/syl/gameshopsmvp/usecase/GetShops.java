package com.example.syl.gameshopsmvp.usecase;

import com.example.syl.gameshopsmvp.global.model.Shop;

import java.util.List;

public interface GetShops {
    void getShops(Listener listener);

    interface Listener {
        void onSuccess(List<Shop> shops);
        void onError(String message);
    }
}