package com.skichrome.detectiveandroid.fragments.rooms;

import android.app.AlertDialog;
import android.util.Log;

import com.skichrome.detectiveandroid.R;
import com.skichrome.detectiveandroid.base.BaseFragment;

import butterknife.OnClick;

public class HallFragment extends BaseFragment
{
    // =======================================
    //           new instance Method
    // =======================================

    public static HallFragment newInstance() { return new HallFragment(); }

    // =======================================
    //           Superclass Methods
    // =======================================

    @Override
    protected int getFragmentLayout() { return R.layout.fragment_hall; }

    @Override
    protected void configureFragment() { }

    // =======================================
    //             OnClick Methods
    // =======================================

    @OnClick(R.id.hall_trombonne)
    void onClickTrombonne()
    {
        showErrorLog("Img clicked");
        configureAlertDialog();
    }

    private void configureAlertDialog()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Vous avez rammassé un nouvel objet !")
                .setMessage("Que voulez-vous en faire ?")
                .setPositiveButton("ramasser", (dialog, which) -> showErrorLog("bouton rammasser"))
                .setNegativeButton("jeter", (dialog, which) -> showErrorLog("bouton jeter"))
                .create()
                .show();
    }

    private static void showErrorLog(String msg)
    {
        Log.e("HallFragment", msg);
    }
}