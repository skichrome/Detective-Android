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
    void onClickTrombone()
    {
        showErrorLog("Trombone clicked");
        configureAlertDialog();
    }

    @OnClick(R.id.hall_case)
    void onClickCase()
    {
        showErrorLog("Case clicked");
        configureAlertDialog();
    }

    private void configureAlertDialog()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Vous avez trouvé un nouvel objet !")
                .setMessage("Que voulez-vous en faire ?")
                .setPositiveButton("ramasser", (dialog, which) -> showErrorLog("bouton ramasser"))
                .setNegativeButton("jeter", (dialog, which) -> showErrorLog("bouton jeter"))
                .setIcon(R.drawable.ic_business_center_black_24dp)
                .create()
                .show();

//        builder.setView(getLayoutInflater().inflate(R.layout.alert_dialog_inventaire, null))
//                .setTitle("Objet trouvé")
//                .setPositiveButton("rammasser", null)
//                .setNegativeButton("jeter", null)
//                .create()
//                .show();
    }

    private static void showErrorLog(String msg)
    {
        Log.e("HallFragment", msg);
    }
}