package com.skichrome.detectiveandroid.fragments.rooms;

import android.view.View;

import com.skichrome.detectiveandroid.R;
import com.skichrome.detectiveandroid.base.BaseFragment;
import com.skichrome.detectiveandroid.models.FragmentsList;

import butterknife.OnClick;

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

    @OnClick({R.id.btnGoToHallFromGarden, R.id.btnGoToLibraryFromGarden})
    void onClickBtn(View view)
    {
        switch (view.getId())
        {
            case R.id.btnGoToLibraryFromGarden :
                mCallback.get().onClickBtn(FragmentsList.LIBRARY);
                break;
            case R.id.btnGoToHallFromGarden :
                mCallback.get().onClickBtn(FragmentsList.HALL);
                break;
        }
    }
}