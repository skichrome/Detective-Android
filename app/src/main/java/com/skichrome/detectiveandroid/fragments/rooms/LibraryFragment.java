package com.skichrome.detectiveandroid.fragments.rooms;

import com.skichrome.detectiveandroid.R;
import com.skichrome.detectiveandroid.base.BaseFragment;

public class LibraryFragment extends BaseFragment
{
    // =======================================
    //           new instance Method
    // =======================================

    public static LibraryFragment newInstance() { return new LibraryFragment(); }

    // =======================================
    //           Superclass Methods
    // =======================================

    @Override
    protected int getFragmentLayout() { return R.layout.fragment_library; }
    @Override
    protected void configureFragment() { }
}