package com.skichrome.detectiveandroid.models;

import android.support.v4.app.Fragment;
import com.skichrome.detectiveandroid.fragments.StartGameFragment;
import com.skichrome.detectiveandroid.fragments.rooms.HallFragment;

public enum FragmentsList
{
    START_GAME(StartGameFragment.newInstance()),
    HALL(HallFragment.newInstance());

    private Fragment mFragment;

    FragmentsList(Fragment fragment)
    {
        this.mFragment = fragment;
    }

    public Fragment getFragment() { return this.mFragment; }
}