package com.skichrome.detectiveandroid.activities;

import android.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.skichrome.detectiveandroid.R;
import com.skichrome.detectiveandroid.base.BaseActivity;
import com.skichrome.detectiveandroid.base.BaseFragment;
import com.skichrome.detectiveandroid.fragments.MapDialogFragment;
import com.skichrome.detectiveandroid.fragments.StartGameFragment;
import com.skichrome.detectiveandroid.fragments.rooms.BathroomFragment;
import com.skichrome.detectiveandroid.fragments.rooms.BedroomFragment;
import com.skichrome.detectiveandroid.fragments.rooms.DesktopFragment;
import com.skichrome.detectiveandroid.fragments.rooms.GardenFragment;
import com.skichrome.detectiveandroid.fragments.rooms.HallFragment;
import com.skichrome.detectiveandroid.fragments.rooms.KitchenFragment;
import com.skichrome.detectiveandroid.fragments.rooms.LibraryFragment;
import com.skichrome.detectiveandroid.fragments.rooms.LivingFragment;
import com.skichrome.detectiveandroid.models.FragmentsList;

import butterknife.BindView;

public class GameActivity extends BaseActivity implements BaseFragment.ButtonListeners
{
    //=========================================
    // Fields
    //=========================================

    @BindView(R.id.activity_toolbar) Toolbar mToolbar;

    private StartGameFragment mStartGameFragment;
    private HallFragment mHallFragment;
    private KitchenFragment mKitchenFragment;
    private LivingFragment mLivingFragment;
    private GardenFragment mGardenFragment;
    private BathroomFragment mBathroomFragment;
    private DesktopFragment mDesktopFragment;
    private LibraryFragment mLibraryFragment;
    private BedroomFragment mBedroomFragment;

    //=========================================
    // Superclass Methods
    //=========================================

    @Override
    protected int getActivityLayout()
    {
        return R.layout.activity_game;
    }

    @Override
    protected void configureActivity()
    {
        this.configureToolbar();
        this.configureStartGameFragment();
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        // Todo save the game before quit
    }

    @Override
    public void onClickBtn(FragmentsList frag)
    {
        switch (frag)
        {
            case GARDEN:
                configureGardenFragment();
                break;
            case LIVING:
                configureLivingFragment();
                break;
            case KITCHEN:
                configureKitchenFragment();
                break;
            case BATHROOM:
                configureBathRoomFragment();
                break;
            case DESKTOP:
                configureDesktopFragment();
                break;
            case LIBRARY:
                configureLibraryFragment();
                break;
            case BEDROOM:
                configureBedRoomFragment();
                break;
            default:
                configureHallFragment();
        }
    }

    //=========================================
    // Toolbar methods
    //=========================================

    private void configureToolbar()
    {
        setSupportActionBar(mToolbar);
        mToolbar.inflateMenu(R.menu.activity_game_menu);
        ActionBar ab = getActionBar();
        if (ab != null)
        {
            ab.setDisplayShowTitleEnabled(false);
            ab.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.activity_game_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.activity_game_menu_pause:
                return true;
            case R.id.activity_game_menu_map_access:
                this.launchMapDialogFragment();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //=========================================
    // Fragment Methods
    //=========================================

    private void displayFragment(Fragment mFragment)
    {
        if (!mFragment.isVisible())
            getSupportFragmentManager().beginTransaction().replace(R.id.activity_game_fragment_container, mFragment).commit();
    }

    private void configureStartGameFragment()
    {
        if (mStartGameFragment == null) mStartGameFragment = StartGameFragment.newInstance();
        displayFragment(mStartGameFragment);
    }

    private void configureHallFragment()
    {
        if (mHallFragment == null) mHallFragment = HallFragment.newInstance();
        displayFragment(mHallFragment);
    }

    private void configureKitchenFragment()
    {
        if (mKitchenFragment == null) mKitchenFragment = KitchenFragment.newInstance();
        displayFragment(mKitchenFragment);
    }

    private void configureGardenFragment()
    {
        if (mGardenFragment == null) mGardenFragment = GardenFragment.newInstance();
        displayFragment(mGardenFragment);
    }

    private void configureLivingFragment()
    {
        if (mLivingFragment == null) mLivingFragment = LivingFragment.newInstance();
        displayFragment(mLivingFragment);
    }

    private void configureBathRoomFragment()
    {
        if (mBathroomFragment == null) mBathroomFragment = BathroomFragment.newInstance();
        displayFragment(mBathroomFragment);
    }

    private void configureDesktopFragment()
    {
        if (mDesktopFragment == null) mDesktopFragment = DesktopFragment.newInstance();
        displayFragment(mDesktopFragment);
    }

    private void configureLibraryFragment()
    {
        if (mLibraryFragment == null) mLibraryFragment = LibraryFragment.newInstance();
        displayFragment(mLibraryFragment);
    }

    private void configureBedRoomFragment()
    {
        if (mBedroomFragment == null) mBedroomFragment = BedroomFragment.newInstance();
        displayFragment(mBedroomFragment);
    }

    private void launchMapDialogFragment()
    {
        MapDialogFragment dialogFragment = new MapDialogFragment();
        dialogFragment.show(getSupportFragmentManager(), "MyCustomDialog");
    }
}