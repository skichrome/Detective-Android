package com.skichrome.detectiveandroid.fragments.rooms;

import android.app.AlertDialog;
import android.util.Log;
import android.view.View;

import butterknife.OnClick;
import com.skichrome.detectiveandroid.R;
import com.skichrome.detectiveandroid.base.BaseFragment;
import com.skichrome.detectiveandroid.inventorymanagement.ObjectsAvailable;
import com.skichrome.detectiveandroid.models.FragmentsList;

import org.jetbrains.annotations.NotNull;

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
    protected void configureFragment() {  }

    // =======================================
    //             OnClick Methods
    // =======================================

    @OnClick({R.id.btnGoToKitchenFromHall, R.id.btnGoToGardenFromHall, R.id.btnGoToLivingFromHall})
    void onClickBtn(View view)
    {
        switch (view.getId())
        {
            case R.id.btnGoToKitchenFromHall:
                mCallback.get().onClickBtn(FragmentsList.KITCHEN);
                break;
            case R.id.btnGoToGardenFromHall:
                mCallback.get().onClickBtn(FragmentsList.GARDEN);
                break;
            case R.id.btnGoToLivingFromHall:
                mCallback.get().onClickBtn(FragmentsList.LIVING);
                break;
        }
    }

    @OnClick({R.id.hall_trombonne, R.id.hall_case})
    void onClickItem(View view)
    {
        switch (view.getId())
        {
            case R.id.hall_trombonne:
                showErrorLog("Trombone clicked");
                createAndShowAlertDialog(ObjectsAvailable.TROMBONE);
                break;
            case R.id.hall_case:
                showErrorLog("Case clicked");
                createAndShowAlertDialog(ObjectsAvailable.CASE);
                break;
        }
    }

    // =======================================
    //                 Methods
    // =======================================

    private void createAndShowAlertDialog(@NotNull ObjectsAvailable foundObject)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Vous avez trouvé un nouvel objet ! : " + foundObject.getName())
                .setMessage(foundObject.getDescription())
                .setPositiveButton("ramasser", (dialog, which) -> showErrorLog("bouton ramasser"))
                .setNegativeButton("jeter", (dialog, which) -> showErrorLog("bouton jeter"))
                .setIcon(foundObject.getImageId())
                .create()
                .show();
    }

    private static void showErrorLog(String msg)
    {
        Log.e("HallFragment", msg);
    }
}