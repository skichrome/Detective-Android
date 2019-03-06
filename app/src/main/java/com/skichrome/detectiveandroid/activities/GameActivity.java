package com.skichrome.detectiveandroid.activities;

import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.skichrome.detectiveandroid.R;
import com.skichrome.detectiveandroid.base.BaseActivity;
import com.skichrome.detectiveandroid.base.BaseFragment;
import com.skichrome.detectiveandroid.fragments.MapDialogFragment;
import com.skichrome.detectiveandroid.fragments.StartGameFragment;

import butterknife.BindView;
import com.skichrome.detectiveandroid.fragments.rooms.HallFragment;
import com.skichrome.detectiveandroid.fragments.rooms.KitchenFragment;

public class GameActivity extends BaseActivity implements BaseFragment.ButtonListeners
{
    //=========================================
    // Fields
    //=========================================

    @BindView(R.id.activity_toolbar) Toolbar mToolbar;

    private StartGameFragment mStartGameFragment;
    private HallFragment mHallFragment;
    private KitchenFragment mKitchenFragment;

    //=========================================
    // Superclass Methods
    //=========================================

    @Override
    protected int getActivityLayout() { return R.layout.activity_game; }
    @Override
    protected void configureActivity()
    {
        this.configureToolbar();
        this.configureStartGameFragment();
    }
    @Override
    protected void updateActivity() { }

    @Override
    protected void onStop()
    {
        super.onStop();
        // Todo save the game before quit
    }

    @Override
    public void onClickBtn(Fragment fragment)
    {
        // Todo voir comment générifier pour éviter un gros switch, ou comment avoir un système d'id pour la même raison (hashmap ?)
        // Enumération avec une liste d'id ?
        // Mettre les Weakreferences dans le baseFragment ?
    }

    //=========================================
    // Toolbar methods
    //=========================================

    private void configureToolbar()
    {
        setSupportActionBar(mToolbar);
        mToolbar.inflateMenu(R.menu.activity_game_menu);
        ActionBar ab = getSupportActionBar();
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
            case R.id.activity_game_menu_pause : return true;
            case R.id.activity_game_menu_map_access :
                this.launchMapDialogFragment();
                return true;
            default : return super.onOptionsItemSelected(item);
        }
    }

    //=========================================
    // Fragment Methods
    //=========================================

    private void displayFragment(Fragment mFragment)
    {
        if (!mFragment.isVisible()) getSupportFragmentManager().beginTransaction().replace(R.id.activity_game_fragment_container, mFragment).commit();
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

    private void launchMapDialogFragment()
    {
        MapDialogFragment dialogFragment = new MapDialogFragment();
        dialogFragment.show(getSupportFragmentManager(), "MyCustomDialog");
    }
}