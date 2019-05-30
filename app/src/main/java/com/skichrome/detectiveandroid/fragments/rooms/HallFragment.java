package com.skichrome.detectiveandroid.fragments.rooms;

import android.app.AlertDialog;
import android.util.Log;
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

    @OnClick(R.id.btn_cuisine)
    void goToKitchen()
    {
        mCallback.get().onClickBtn(FragmentsList.KITCHEN);
    }

    @OnClick(R.id.btn_jardin)
    void goToGarden()
    {
        mCallback.get().onClickBtn(FragmentsList.GARDEN);
    }

    @OnClick(R.id.btn_salon)
    void goToLiving()
    {
        mCallback.get().onClickBtn(FragmentsList.LIVING);
    }

    @OnClick(R.id.hall_trombonne)
    void onClickTrombone()
    {
        showErrorLog("Trombone clicked");
        createAndShowAlertDialog(mTrombonne);
    }

    @OnClick(R.id.hall_case)
    void onClickCase()
    {
        showErrorLog("Case clicked");
        createAndShowAlertDialog(mValise);
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