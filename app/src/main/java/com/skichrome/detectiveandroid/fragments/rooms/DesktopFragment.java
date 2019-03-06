package com.skichrome.detectiveandroid.fragments.rooms;

import com.skichrome.detectiveandroid.R;
import com.skichrome.detectiveandroid.base.BaseFragment;

public class DesktopFragment extends BaseFragment
{
    // =======================================
    //           new instance Method
    // =======================================

    public static DesktopFragment newInstance() { return new DesktopFragment(); }

    // =======================================
    //           Superclass Methods
    // =======================================

    @Override
    protected int getFragmentLayout() { return R.layout.fragment_desktop; }
    @Override
    protected void configureFragment() { }
}