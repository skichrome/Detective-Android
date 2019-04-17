package com.skichrome.detectiveandroid.base;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

import java.lang.ref.WeakReference;

public abstract class BaseFragment extends Fragment
{

    // =======================================
    //              Interface(s)
    // =======================================

    public interface ButtonListeners
    {
        void onClickBtn(Fragment fragment);
    }

    // =======================================
    //                  Fields
    // =======================================

    protected WeakReference<ButtonListeners> mCallback;

    // =======================================
    //            Abstract Methods
    // =======================================

    protected abstract int getFragmentLayout();
    protected abstract void configureFragment();

    // =======================================
    //              Constructor
    // =======================================

    public BaseFragment() { }

    // =======================================
    //           Superclass Methods
    // =======================================

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(this.getFragmentLayout(), container, false);

        this.mCallback = new WeakReference<>((ButtonListeners) getActivity());

        ButterKnife.bind(this, view);
        this.configureFragment();
        return view;
    }
}