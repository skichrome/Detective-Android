package com.skichrome.detectiveandroid.fragments.rooms;

import android.view.View;

import com.skichrome.detectiveandroid.R;
import com.skichrome.detectiveandroid.base.BaseFragment;
import com.skichrome.detectiveandroid.models.FragmentsList;

import butterknife.OnClick;

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

    @OnClick({R.id.btnGoToLibraryFromLiving, R.id.btnGoToGardenFromLiving, R.id.btnGoToHallFromLiving})
    void onClickBtn(View view)
    {
        switch (view.getId())
        {
            case R.id.btnGoToLibraryFromLiving :
                mCallback.get().onClickBtn(FragmentsList.LIBRARY);
                break;
            case R.id.btnGoToGardenFromLiving :
                mCallback.get().onClickBtn(FragmentsList.GARDEN);
                break;
            case R.id.btnGoToHallFromLiving :
                mCallback.get().onClickBtn(FragmentsList.HALL);
                break;
        }
    }
}