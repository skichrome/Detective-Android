package com.skichrome.detectiveandroid.models;

public enum FragmentsList
{
    START_GAME(0),
    HALL(1);

    private int mFragmentId;

    FragmentsList(int fragmentId) { this.mFragmentId = fragmentId; }

    public int getId() { return this.mFragmentId; }
}