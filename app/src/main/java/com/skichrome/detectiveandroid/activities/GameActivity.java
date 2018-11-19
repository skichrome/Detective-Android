package com.skichrome.detectiveandroid.activities;

import android.support.v4.app.Fragment;

import com.skichrome.detectiveandroid.R;
import com.skichrome.detectiveandroid.base.BaseActivity;
import com.skichrome.detectiveandroid.fragments.StartGameFragment;

public class GameActivity extends BaseActivity
{
    //=========================================
    // Fields
    //=========================================

    private StartGameFragment startGameFragment;

    //=========================================
    // Superclass Methods
    //=========================================

    @Override
    protected int getActivityLayout() { return R.layout.activity_game; }
    @Override
    protected void configureActivity() { this.configureStartGameFragment(); }
    @Override
    protected void updateActivity() { }

    //=========================================
    // Fragment Methods
    //=========================================

    private void displayFragment(Fragment mFragment)
    {
        if (!mFragment.isVisible()) getSupportFragmentManager().beginTransaction().replace(R.id.activity_game_fragment_container, mFragment).commit();
    }

    private void configureStartGameFragment()
    {
        if (startGameFragment == null) startGameFragment = StartGameFragment.newInstance();
        displayFragment(startGameFragment);
    }
}