package com.example.syl.gameshopsmvp.ui.presenter;

import android.content.Context;
import android.content.Intent;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsPresenter extends Presenter<MapsPresenter.View, MapsPresenter.Navigator> {

    Context context;

    String nameShop;
    float latitude, longitude;
    float zoomLevel = 16.5f;

    public MapsPresenter(Context context) {
        this.context = context;
    }

    public void onExtrasReceived(Intent intent) {
        String nameShop = (String) intent.getExtras().get("name");
        float latitude = (float) intent.getExtras().get("latitude");
        float longitude = (float) intent.getExtras().get("longitude");

        this.nameShop = nameShop;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public void onMapReady(GoogleMap googleMap) {
        LatLng sydney = new LatLng(this.latitude, this.longitude);
        googleMap.addMarker(new MarkerOptions().position(sydney).title(nameShop));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, zoomLevel));
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

    }

    public interface Navigator {

    }
}
