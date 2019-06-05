package com.skichrome.detectiveandroid.fragments.rooms;

import android.view.View;

import com.skichrome.detectiveandroid.R;
import com.skichrome.detectiveandroid.base.BaseFragment;
import com.skichrome.detectiveandroid.models.FragmentsList;

import butterknife.OnClick;

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

    @OnClick({R.id.btnGoToBathFromDesktop, R.id.btnGoToBedroomFromDesktop, R.id.btnGoToLibraryFromDesktop})
    void onClickBtn(View view)
    {
        switch (view.getId())
        {
            case R.id.btnGoToBathFromDesktop :
                mCallback.get().onClickBtn(FragmentsList.BATHROOM);
                break;
            case R.id.btnGoToBedroomFromDesktop :
                mCallback.get().onClickBtn(FragmentsList.BEDROOM);
                break;
            case R.id.btnGoToLibraryFromDesktop :
                mCallback.get().onClickBtn(FragmentsList.LIBRARY);
                break;
        }
    }
}