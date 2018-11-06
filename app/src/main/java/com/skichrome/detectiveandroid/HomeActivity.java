package com.skichrome.detectiveandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.activity_home_btn_new_game)
    void onClickBtnNewGame() { }

    @OnClick(R.id.activity_home_btn_resume_game)
    void onClickBtnResume() { }

    @OnClick(R.id.activity_home_btn_quit)
    void onClickBtnQuit()
    {
        //TODO Comment bien quitter l'application ?
        //this.finish();
        //System.exit(0);
    }
}
