package com.skichrome.detectiveandroid.fragments.rooms;

import android.view.View;

import com.skichrome.detectiveandroid.R;
import com.skichrome.detectiveandroid.base.BaseFragment;
import com.skichrome.detectiveandroid.models.FragmentsList;

import butterknife.OnClick;

public class KitchenFragment extends BaseFragment
{
    // =======================================
    //           new instance Method
    // =======================================

    public static KitchenFragment newInstance()
    {
        return new KitchenFragment();
    }

    // =======================================
    //           Superclass Methods
    // =======================================

    @Override
    protected int getFragmentLayout()
    {
        return R.layout.fragment_kitchen;
    }

    @Override
    protected void configureFragment() { }

    @OnClick({R.id.btnGoToGardenFromKitchen, R.id.btnGoToHallFromKitchen, R.id.btnGoToLibraryFromKitchen})
    void onClickBtn(View view)
    {
        switch (view.getId())
        {
            case R.id.btnGoToGardenFromKitchen :
                mCallback.get().onClickBtn(FragmentsList.GARDEN);
                break;
            case R.id.btnGoToHallFromKitchen :
                mCallback.get().onClickBtn(FragmentsList.HALL);
                break;
            case R.id.btnGoToLibraryFromKitchen :
                mCallback.get().onClickBtn(FragmentsList.LIBRARY);
                break;
        }
    }

    @OnClick(R.id.kitchen_frag_knife_img)
    void onClickKnife()
    {
    }
}