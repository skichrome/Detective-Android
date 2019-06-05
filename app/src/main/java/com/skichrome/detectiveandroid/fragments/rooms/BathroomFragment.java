package com.skichrome.detectiveandroid.fragments.rooms;

import android.view.View;

import com.skichrome.detectiveandroid.R;
import com.skichrome.detectiveandroid.base.BaseFragment;
import com.skichrome.detectiveandroid.models.FragmentsList;

import butterknife.OnClick;

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

    @OnClick({R.id.btnGoToBedroomFromBath, R.id.btnGoToDesktopFromBath, R.id.btnGoToLibraryFromBath})
    void onClickBtn(View view)
    {
        switch (view.getId())
        {
            case R.id.btnGoToBedroomFromBath:
                mCallback.get().onClickBtn(FragmentsList.BEDROOM);
                break;
            case R.id.btnGoToDesktopFromBath:
                mCallback.get().onClickBtn(FragmentsList.DESKTOP);
                break;
            case R.id.btnGoToLibraryFromBath:
                mCallback.get().onClickBtn(FragmentsList.LIBRARY);
                break;
        }
    }
}