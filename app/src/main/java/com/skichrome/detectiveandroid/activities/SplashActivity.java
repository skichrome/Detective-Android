package com.skichrome.detectiveandroid.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

public class SplashActivity extends Activity
{
    //=========================
    // Superclass Methods
    //=========================

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.startHomeActivity();
        this.finish();
    }

    private void startHomeActivity()
    {
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(intent);
    }
}