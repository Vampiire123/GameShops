package com.example.syl.gameshopsmvp.datasource;

public class GetShopsMockImpl implements GetShops {
    @Override public void getShops(GetShops.Listener listener) {
        List<Shop> shops = new ArrayList<Shop>();

        shops.add(createShop(1, "Game Shop Recogidas", 37.23423423f, -3.234234234f));
        shops.add(createShop(2, "Game Shop Recogidas", 37.23423423f, -3.234234234f));
        shops.add(createShop(3, "Game Shop Recogidas", 37.23423423f, -3.234234234f));

        listener.onSuccess(shops);
    }
}