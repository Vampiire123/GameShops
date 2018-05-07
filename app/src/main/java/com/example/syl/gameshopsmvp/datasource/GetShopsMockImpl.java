package com.example.syl.gameshopsmvp.datasource;

import com.example.syl.gameshopsmvp.global.model.Shop;
import com.example.syl.gameshopsmvp.usecase.GetShops;

import java.util.ArrayList;
import java.util.List;

public class GetShopsMockImpl implements GetShops {
    @Override
    public void getShops(GetShops.Listener listener) {
        List<Shop> shops = new ArrayList<Shop>();

        String evoGamesImage = "https://lh5.googleusercontent.com/p/"
                + "AF1QipOrMqnosJ3hUSCv3jQpHGoXAfymIN4Y2YJSV__l=w408-h306-k-no";
        String cexImage = "https://lh5.googleusercontent.com/p/"
                + "AF1QipOE72XqRfIlwe_dumAYLugdU5Xx0UzlpnAUVMxV=w408-h306-k-no";
        String gameRecogidasImage = "https://lh5.googleusercontent.com/p/"
                + "AF1QipOY7FnAf9dE0hxmhoy_dOw3izskZLGhWfu-JRwq=w408-h229-k-no";
        String gameStoresArmillaImage = "https://lh5.googleusercontent.com/p/"
                + "AF1QipPf7qPr0iE9NjMbdf_mGdyceFH6eYaA2nv-YLsZ=w408-h306-k-no";
        String gameNevadaImage = "https://lh5.googleusercontent.com/p/"
                + "AF1QipN9zoC7SzMEL-JpeFrsRuJ_HwLnudY5qaiJAxFq=w408-h229-k-no";
        String gameAlcampoImage = "https://lh5.googleusercontent.com/p/"
                + "AF1QipOg4MisRksqnHKhOvnbGf4LJqa14qT_GhUj4auF=w408-h544-k-no";

        shops.add(createShop(1, "EvoGames", "Granada", 37.173303f,
                -3.6006009999999833f, evoGamesImage));
        shops.add(createShop(2, "CeX", "Granada", 37.1723661f,
                -3.6001010999999608f, cexImage));
        shops.add(createShop(3, "Game Recogidas", "Granada", 37.1712292f,
                -3.6037056999999777f, gameRecogidasImage));
        shops.add(createShop(4, "Game Stores Armilla", "Granada", 37.1550598f,
                -3.6083455000000413f, gameStoresArmillaImage));
        shops.add(createShop(5, "GAME Nevada", "Granada", 37.1460565f,
                -3.613816300000053f, gameNevadaImage));
        shops.add(createShop(6, "Game Alcampo", "Granada", 37.19784380000001f,
                -3.609327099999973f, gameAlcampoImage));

        listener.onSuccess(shops);
    }

    private Shop createShop(int id, String name, String locality, float latitude, float longitude, String imageUrl) {
        Shop shop = new Shop();
        shop.setId(id);
        shop.setName(name);
        shop.setLongitude(longitude);
        shop.setLatitude(latitude);
        shop.setImageUrl(imageUrl);
        shop.setLocality(locality);
        return shop;
    }
}