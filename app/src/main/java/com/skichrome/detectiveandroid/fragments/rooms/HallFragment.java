package com.skichrome.detectiveandroid.fragments.rooms;

import android.app.AlertDialog;
import android.util.Log;
import android.view.View;

import butterknife.OnClick;
import com.skichrome.detectiveandroid.R;
import com.skichrome.detectiveandroid.base.BaseFragment;
import com.skichrome.detectiveandroid.models.FragmentsList;
import com.skichrome.detectiveandroid.models.ObjectOnFloor;
import org.jetbrains.annotations.NotNull;

public class HallFragment extends BaseFragment
{
    // =======================================
    //                  Fields
    // =======================================

    private ObjectOnFloor mTrombonne = new ObjectOnFloor(0, "un trombonne", "Ce trombonne est abïmé, pourquoi ?", R.drawable.ic_trombonne);
    private ObjectOnFloor mValise = new ObjectOnFloor(1, "une valise", "tiens un papier retient votre attention, il parle d'une importante somme d'argent cachée dans la maison", R.drawable.ic_business_center_black_24dp);

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
                createAndShowAlertDialog(mTrombonne);
                break;
            case R.id.hall_case:
                showErrorLog("Case clicked");
                createAndShowAlertDialog(mValise);
                break;
        }
    }

    // =======================================
    //                 Methods
    // =======================================

    private void createAndShowAlertDialog(@NotNull ObjectOnFloor foundObject)
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