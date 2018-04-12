package com.example.syl.gameshopsmvp.ui.activity;

import android.os.Bundle;

public abstract class BaseActivity extends android.app.Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayoutId());
    }

    protected abstract int getLayoutId();
}
