package com.skichrome.detectiveandroid.fragments.rooms;

import android.view.View;

import com.skichrome.detectiveandroid.R;
import com.skichrome.detectiveandroid.base.BaseFragment;
import com.skichrome.detectiveandroid.models.FragmentsList;

import butterknife.OnClick;

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

    @OnClick({R.id.btnGoToBathFromBedroom, R.id.btnGoToDesktopFromBedroom, R.id.btnGoToLibraryFromBedroom})
    void onClickBtn(View view)
    {
        switch (view.getId())
        {
            case R.id.btnGoToBathFromBedroom:
                mCallback.get().onClickBtn(FragmentsList.BATHROOM);
                break;
            case R.id.btnGoToDesktopFromBedroom:
                mCallback.get().onClickBtn(FragmentsList.DESKTOP);
                break;
            case R.id.btnGoToLibraryFromBedroom:
                mCallback.get().onClickBtn(FragmentsList.LIBRARY);
                break;
        }
    }
}