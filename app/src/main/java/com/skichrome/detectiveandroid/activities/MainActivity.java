package com.skichrome.detectiveandroid.activities;

import android.content.Intent;
import android.view.View;
import android.widget.ProgressBar;

import com.skichrome.detectiveandroid.R;
import com.skichrome.detectiveandroid.base.BaseActivity;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity
{
    //=========================
    // Fields
    //=========================

    @BindView(R.id.activity_main_progress_bar) ProgressBar progressBar;

    private Timer wait = null;

    //=========================
    // Superclass Methods
    //=========================

    @Override
    protected int getActivityLayout() { return R.layout.activity_main; }
    @Override
    protected void configureActivity() { startAutomatically(); }

    @Override
    protected void onPause()
    {
        super.onPause();
        if (wait != null) wait.cancel();
    }

    //=========================
    // OnCLick Methods
    //=========================

    @OnClick(R.id.activity_main_btn)
    void OnClickBtn() { this.startHomeActivity(); }

    //=========================
    // StartActivity Methods
    //=========================

    private void startAutomatically()
    {
        progressBar.setVisibility(View.VISIBLE);
        wait = new Timer();
        wait.schedule(new TimerTask() { @Override public void run() { runOnUiThread(() -> startHomeActivity()); } },3000);
    }

    private void startHomeActivity()
    {
        progressBar.setVisibility(View.INVISIBLE);
        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
        startActivity(intent);
        this.finish();
    }
}