package com.skichrome.detectiveandroid.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.skichrome.detectiveandroid.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MapDialogFragment extends DialogFragment
{
    //=========================================
    //                 Fields
    //=========================================

    @BindView(R.id.dialog_fragment_img) ImageView mImageView;

    //=========================================
    //                 methods
    //=========================================

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_dialog, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
}