package com.skichrome.detectiveandroid.fragments.rooms;

import com.skichrome.detectiveandroid.R;
import com.skichrome.detectiveandroid.base.BaseFragment;

public class BathroomFragment extends BaseFragment
{
    // =======================================
    //           new instance Method
    // =======================================

    public static BathroomFragment newInstance() { return new BathroomFragment(); }

    // =======================================
    //           Superclass Methods
    // =======================================

    @Override
    protected int getFragmentLayout() { return R.layout.fragment_bathroom; }
    @Override
    protected void configureFragment() { }
}