package com.skichrome.detectiveandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity
{
    private Timer wait = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        startAutomatically();
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        if (wait != null) wait.cancel();
    }

    @OnClick(R.id.activity_main_btn)
    void OnClickBtn() { this.startHomeActivity(); }

    private void startAutomatically()
    {
        wait = new Timer();
        wait.schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                runOnUiThread(new Runnable()
                {
                    @Override
                    public void run() { startHomeActivity(); }
                });
            }
        },5000);
    }

    private void startHomeActivity()
    {
        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
        startActivity(intent);
    }
}