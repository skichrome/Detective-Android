package com.skichrome.detectiveandroid.fragments.rooms;

import com.skichrome.detectiveandroid.R;
import com.skichrome.detectiveandroid.base.BaseFragment;

public class KitchenFragment extends BaseFragment
{
    // =======================================
    //           new instance Method
    // =======================================

    public static KitchenFragment newInstance() { return new KitchenFragment(); }

    // =======================================
    //           Superclass Methods
    // =======================================

    @Override
    protected int getFragmentLayout() { return R.layout.fragment_kitchen; }
    @Override
    protected void configureFragment()
    {
    }
}