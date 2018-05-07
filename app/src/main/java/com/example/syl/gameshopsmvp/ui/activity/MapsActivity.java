package com.example.syl.gameshopsmvp.ui.activity;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.example.syl.gameshopsmvp.ui.presenter.MapsPresenter;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.example.syl.gameshopsmvp.R;

public class MapsActivity extends FragmentActivity implements
        OnMapReadyCallback, MapsPresenter.View, MapsPresenter.Navigator {

    MapsPresenter mapsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        mapsPresenter = new MapsPresenter(this);

        mapsPresenter.setView(this);
        mapsPresenter.setNavigator(this);

        mapsPresenter.initialize();
        mapsPresenter.onExtrasReceived(getIntent());

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapsPresenter.onMapReady(googleMap);
    }
}