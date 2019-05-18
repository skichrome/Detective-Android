package com.skichrome.detectiveandroid.models;

public enum FragmentsList
{
    START_GAME(0),
    HALL(1),
    KITCHEN(2),
    LIBRARY(3),
    LIVING(4),
    BATHROOM(5),
    BEDROOM(6),
    DESKTOP(7),
    GARDEN(8);

    private int mFragmentId;

    FragmentsList(int fragmentId) { this.mFragmentId = fragmentId; }

    public int getId() { return this.mFragmentId; }
}