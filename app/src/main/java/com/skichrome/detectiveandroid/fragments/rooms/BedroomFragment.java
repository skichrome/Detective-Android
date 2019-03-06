package com.skichrome.detectiveandroid.fragments.rooms;

import com.skichrome.detectiveandroid.R;
import com.skichrome.detectiveandroid.base.BaseFragment;

public class BedroomFragment extends BaseFragment
{
    // =======================================
    //           new instance Method
    // =======================================

    public static BedroomFragment newInstance() { return new BedroomFragment(); }

    // =======================================
    //           Superclass Methods
    // =======================================

    @Override
    protected int getFragmentLayout() { return R.layout.fragment_bedroom; }
    @Override
    protected void configureFragment() { }
}