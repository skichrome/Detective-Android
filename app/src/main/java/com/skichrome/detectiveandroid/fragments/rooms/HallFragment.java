package com.skichrome.detectiveandroid.fragments.rooms;

import com.skichrome.detectiveandroid.R;
import com.skichrome.detectiveandroid.base.BaseFragment;

public class HallFragment extends BaseFragment
{
    // =======================================
    //           new instance Method
    // =======================================

    public static HallFragment newInstance() { return new HallFragment(); }

    // =======================================
    //           Superclass Methods
    // =======================================

    @Override
    protected int getFragmentLayout() { return R.layout.fragment_hall; }
    @Override
    protected void configureFragment()
    {
    }
}