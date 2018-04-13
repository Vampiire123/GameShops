package com.example.syl.gameshopsmvp.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.widget.Toast;

import com.example.syl.gameshopsmvp.R;
import com.example.syl.gameshopsmvp.datasource.GetShopsMockImpl;
import com.example.syl.gameshopsmvp.global.model.Shop;
import com.example.syl.gameshopsmvp.ui.presenter.ShopPresenter;
import com.example.syl.gameshopsmvp.ui.renderer.ShopRenderer;
import com.example.syl.gameshopsmvp.ui.renderer.ShopRendererBuilder;
import com.pedrogomez.renderers.ListAdapteeCollection;
import com.pedrogomez.renderers.RVRendererAdapter;

import java.util.ArrayList;
import java.util.List;

public class ShopActivity extends BaseActivity implements ShopPresenter.View {

    ShopPresenter shopPresenter;

    GetShopsMockImpl getShopsMockImpl;
    private RecyclerView recyclerView;
    private RVRendererAdapter<Shop> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getShopsMockImpl = new GetShopsMockImpl();

        shopPresenter = new ShopPresenter(this, getShopsMockImpl);

        shopPresenter.setView(this);

        adapter = new RVRendererAdapter<>(
                LayoutInflater.from(this),
                new ShopRendererBuilder(this, new ShopRenderer.OnShopClicked() {
                    @Override
                    public void onClickShop(Shop shop) {
                        shopPresenter.onShopClicked(shop);
                    }
                }),
                new ListAdapteeCollection<>(new ArrayList<Shop>()));

        recyclerView = findViewById(R.id.rv_shops);

        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        shopPresenter.initialize();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_shop;
    }

    @Override
    public void showShops(List<Shop> shops) {
        adapter.addAll(shops);

        adapter.notifyDataSetChanged();
    }

    @Override
    public void showShop(Shop shop) {
        Toast.makeText(this, shop.getName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}