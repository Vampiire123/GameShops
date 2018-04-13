package com.example.syl.gameshopsmvp.ui.renderer;

import android.content.Context;

import com.example.syl.gameshopsmvp.global.model.Shop;
import com.pedrogomez.renderers.Renderer;
import com.pedrogomez.renderers.RendererBuilder;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class ShopRendererBuilder extends RendererBuilder<Shop> {

    public ShopRendererBuilder(Context context, ShopRenderer.OnShopClicked onShopClicked) {
        Collection<Renderer<Shop>> prototypes = getPrototypes(context, onShopClicked);
        setPrototypes(prototypes);
    }

    @Override
    protected Class getPrototypeClass(Shop content) {
        return ShopRenderer.class;
    }

    private List<Renderer<Shop>> getPrototypes(Context context, ShopRenderer.OnShopClicked onShopClicked) {
        List<Renderer<Shop>> prototypes = new LinkedList<>();

        ShopRenderer shopRenderer = new ShopRenderer(context, onShopClicked);
        prototypes.add(shopRenderer);

        return prototypes;
    }
}