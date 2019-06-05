package com.skichrome.detectiveandroid.fragments.rooms;

import android.view.View;

import com.skichrome.detectiveandroid.R;
import com.skichrome.detectiveandroid.base.BaseFragment;
import com.skichrome.detectiveandroid.models.FragmentsList;

import butterknife.OnClick;

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

    @OnClick({R.id.btnGoToBathFromLibrary, R.id.btnGoToBedroomFromLibrary, R.id.btnGoToHallFromLibrary})
    void onClickBtn(View view)
    {
        switch (view.getId())
        {
            case R.id.btnGoToBathFromLibrary :
                mCallback.get().onClickBtn(FragmentsList.BATHROOM);
                break;
            case R.id.btnGoToBedroomFromLibrary :
                mCallback.get().onClickBtn(FragmentsList.BEDROOM);
                break;
            case R.id.btnGoToHallFromLibrary:
                mCallback.get().onClickBtn(FragmentsList.HALL);
                break;
        }
    }
}