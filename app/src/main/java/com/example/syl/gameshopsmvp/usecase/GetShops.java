package com.example.syl.gameshopsmvp.usecase;

interface GetShops {
    void getShops(Listener listener);

    interface Listener {
        void onSuccess(List<Shop> shops);
        void onError(String message);
    }
}