package com.kv.lifecycle;

import android.annotation.SuppressLint;
import android.app.Fragment;

/**
 * Created by tanjunzhao on 5/10/21.
 */
public class LifecycleManagerFragment extends Fragment {

    private final ActivityFragmentLifecycle lifecycle;

    public LifecycleManagerFragment() {
        this(new ActivityFragmentLifecycle());
    }

    @SuppressLint("ValidFragment")
    LifecycleManagerFragment(ActivityFragmentLifecycle lifecycle) {
        this.lifecycle = lifecycle;
    }

    public ActivityFragmentLifecycle getQfqLifecycle() {
        return lifecycle;
    }

    @Override
    public void onStart() {
        super.onStart();
        lifecycle.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        lifecycle.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        lifecycle.onDestroy();
    }
}
