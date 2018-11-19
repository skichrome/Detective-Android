package com.skichrome.detectiveandroid.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment
{
    protected abstract int getFragmentLayout();
    protected abstract void configureFragment();
    protected abstract void updateFragment();

    public BaseFragment() { }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(this.getFragmentLayout(), container, false);

        ButterKnife.bind(this, view);

        this.configureFragment();
        this.updateFragment();

        return view;
    }
}