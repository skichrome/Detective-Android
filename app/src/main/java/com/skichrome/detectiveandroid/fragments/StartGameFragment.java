package com.skichrome.detectiveandroid.fragments;

import android.util.Log;
import android.widget.Button;

import com.skichrome.detectiveandroid.R;
import com.skichrome.detectiveandroid.base.BaseFragment;

import butterknife.BindView;
import butterknife.OnClick;
import com.skichrome.detectiveandroid.models.FragmentsList;

public class StartGameFragment extends BaseFragment
{
    // =======================================
    //                  Fields
    // =======================================

    @BindView(R.id.frag_start_game_btn) Button mBtnStartGame;

    // =======================================
    //           new instance Method
    // =======================================

    public static StartGameFragment newInstance() { return new StartGameFragment(); }

    // =======================================
    //           Superclass Methods
    // =======================================

    @Override
    protected int getFragmentLayout() { return R.layout.fragment_start_game; }
    @Override
    protected void configureFragment() { }

    // =======================================
    //             OnClick Methods
    // =======================================

    @OnClick(R.id.frag_start_game_btn)
    void onClickStart()
    {
        Log.d("Start Game Fragment : ", "You are trying to go into the manor");
        // Todo display next fragment

        this.mCallback.get().onClickBtn(FragmentsList.HALL);
    }
}