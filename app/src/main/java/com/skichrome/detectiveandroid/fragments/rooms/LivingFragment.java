package com.skichrome.detectiveandroid.fragments.rooms;

import com.skichrome.detectiveandroid.R;
import com.skichrome.detectiveandroid.base.BaseFragment;

public class LivingFragment extends BaseFragment
{
    // =======================================
    //           new instance Method
    // =======================================

    public static LivingFragment newInstance() { return new LivingFragment(); }

    // =======================================
    //           Superclass Methods
    // =======================================

    @Override
    protected int getFragmentLayout() { return R.layout.fragment_living; }
    @Override
    protected void configureFragment() { }
}