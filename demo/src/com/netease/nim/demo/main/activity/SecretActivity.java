package com.netease.nim.demo.main.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.netease.nim.demo.R;
import com.netease.nim.demo.main.fragment.SecretGestureFragment;
import com.netease.nim.uikit.common.activity.UI;
import com.netease.nim.uikit.common.fragment.TFragment;
import com.netease.nim.uikit.common.util.log.LogUtil;

public class SecretActivity extends UI {
    private static final String TAG = "SecretActivity";
    private static final String SECRET_TYPE = "SECRET_TYPE";
    private static final int SECRET_GESTURE = 0;
    private static final int SECRET_PASSWORD = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secret);
        onInit(getIntent());
    }

    private void onInit(Intent intent) {
        int type = intent.getIntExtra(SECRET_TYPE, SECRET_GESTURE);
        TFragment fragment = null;
        switch (type) {
            case SECRET_GESTURE:
                fragment = new SecretGestureFragment();
                break;
            default:
                LogUtil.i(TAG, "onInit no suitable fragment!");
        }
        if (fragment == null) finish();
        switchFragmentContent(fragment);
    }

    public static void start(Context context) {
        start(context, SECRET_GESTURE);
    }

    public static void start(Context context, int secretType) {
        Intent intent = new Intent(context, SecretActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        intent.putExtra(SECRET_TYPE, secretType);
        context.startActivity(intent);
    }
}
