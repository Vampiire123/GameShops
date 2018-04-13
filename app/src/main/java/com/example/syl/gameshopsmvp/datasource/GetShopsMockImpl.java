package com.example.syl.gameshopsmvp.datasource;

import com.example.syl.gameshopsmvp.global.model.Shop;
import com.example.syl.gameshopsmvp.usecase.GetShops;

import java.util.ArrayList;
import java.util.List;

public class GetShopsMockImpl implements GetShops {
    @Override
    public void getShops(GetShops.Listener listener) {
        List<Shop> shops = new ArrayList<Shop>();

        String IMAGE = "http://media.gizmodo.co.uk/wp-content/uploads/2017/11/Game_227_store_image-520x349.jpg";
        shops.add(createShop(1, "Game Shop Recogidas", "Granada",  36.37283718f, -3.234234234f, IMAGE));
        shops.add(createShop(2, "Game Shop Nevada", "Granada",35.83948023f, -5.675545479f, IMAGE));
        shops.add(createShop(3, "Game Shop Serrallo", "Granada",37.74893749f, -2.578433356f, IMAGE));

        listener.onSuccess(shops);
    }

    private Shop createShop(int id, String name, String locality, float longitude, float latitude, String imageUrl){
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