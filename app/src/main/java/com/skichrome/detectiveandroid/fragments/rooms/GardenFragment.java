package com.skichrome.detectiveandroid.fragments.rooms;

import com.skichrome.detectiveandroid.R;
import com.skichrome.detectiveandroid.base.BaseFragment;

public class GardenFragment extends BaseFragment
{
    // =======================================
    //           new instance Method
    // =======================================

    public static GardenFragment newInstance() { return new GardenFragment(); }

    // =======================================
    //           Superclass Methods
    // =======================================

    @Override
    protected int getFragmentLayout() { return R.layout.fragment_garden; }
    @Override
    protected void configureFragment() { }
}