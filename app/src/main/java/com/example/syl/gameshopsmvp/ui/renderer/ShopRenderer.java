package com.example.syl.gameshopsmvp.ui.renderer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.syl.gameshopsmvp.R;
import com.example.syl.gameshopsmvp.global.model.Shop;
import com.pedrogomez.renderers.Renderer;
import com.squareup.picasso.Picasso;

public class ShopRenderer extends Renderer<Shop> {

    protected Context context;
    protected OnShopClicked listener = new EmptyOnShopClicked();

    ImageView ivImage;
    TextView tvName, tvLocality;

    public ShopRenderer(Context ctx, OnShopClicked listener) {
        this.context = ctx.getApplicationContext();

        if(listener != null){
            this.listener = listener;
        }
    }

    @Override
    protected void setUpView(View rootView) {
        ivImage = rootView.findViewById(R.id.iv_image);
        tvName = rootView.findViewById(R.id.tv_name);
        tvLocality = rootView.findViewById(R.id.tv_locality);

        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClickShop(getContent());
            }
        });
    }

    @Override
    protected void hookListeners(View rootView) {

    }

    @Override
    protected View inflate(LayoutInflater inflater, ViewGroup parent) {
        return inflater.inflate(R.layout.row_shop, parent, false);
    }

    @Override
    public void render() {
        Shop shop = getContent();
        renderName(shop);
        renderLocality(shop);
        renderImage(shop);
    }

    private void renderImage(Shop shop) {
        Picasso.with(context)
                .load(shop.getImageUrl())
                .into(ivImage);
    }

    private void renderLocality(Shop shop) {
        tvLocality.setText(shop.getLocality());
    }

    private void renderName(Shop shop) {
        tvName.setText(shop.getName());
    }

    public interface OnShopClicked {
        void onClickShop(Shop shop);
    }

    private class EmptyOnShopClicked implements OnShopClicked {
        @Override
        public void onClickShop(Shop shop) {

        }
    }
}
