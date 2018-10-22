package com.netease.nim.demo.main.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.netease.nim.demo.R;
import com.netease.nim.uikit.common.fragment.TFragment;

public class SecretGestureFragment extends TFragment {
    private View rootView = null;
    public SecretGestureFragment(){
        setContainerId(R.id.secret_container);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.secret_gesture, container, false);
        return rootView;
    }
}
