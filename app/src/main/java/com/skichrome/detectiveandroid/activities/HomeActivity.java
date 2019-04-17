package com.skichrome.detectiveandroid.activities;

import android.content.Intent;

import com.skichrome.detectiveandroid.R;
import com.skichrome.detectiveandroid.base.BaseActivity;

import butterknife.OnClick;

public class HomeActivity extends BaseActivity
{
    //=========================
    // Superclass Methods
    //=========================

    @Override
    protected int getActivityLayout() { return R.layout.activity_home; }
    @Override
    protected void configureActivity() { }

    //=========================
    // OnCLick Methods
    //=========================

    @OnClick(R.id.activity_home_btn_new_game)
    void onClickBtnNewGame() { startGameActivity(); }

    @OnClick(R.id.activity_home_btn_resume_game)
    void onClickBtnResume() { }

    //=========================
    // StartActivity Methods
    //=========================

    private void startGameActivity() { startActivity(new Intent(HomeActivity.this, GameActivity.class)); }
}