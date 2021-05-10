package com.kv.lifecycle;

import android.app.Activity;

/**
 * Created by tanjunzhao on 5/10/21.
 */
public class LifecycleDetector {

    static final String FRAGMENT_TAG = "com.kv.lifecycle.manager";

    private static volatile LifecycleDetector sInstance;

    public static LifecycleDetector getInstance() {
        if (sInstance == null) {
            synchronized (LifecycleDetector.class) {
                if (sInstance == null) {
                    sInstance = new LifecycleDetector();
                }
            }
        }

        return sInstance;
    }

    public void observer(Activity activity, LifecycleListener lifecycleListener) {
        // 获取当前activity的FragmentManager
        android.app.FragmentManager fm = activity.getFragmentManager();
        // 注册无UI的fragment
        LifecycleManagerFragment current = getRequestManagerFragment(fm);

        current.getQfqLifecycle().addListener(lifecycleListener);
    }


    LifecycleManagerFragment getRequestManagerFragment(final android.app.FragmentManager fm) {
        LifecycleManagerFragment current = (LifecycleManagerFragment) fm.findFragmentByTag(FRAGMENT_TAG);
        if (current == null) {
            current = new LifecycleManagerFragment();
            fm.beginTransaction().add(current, FRAGMENT_TAG).commitAllowingStateLoss();
        }
        return current;
    }

}
