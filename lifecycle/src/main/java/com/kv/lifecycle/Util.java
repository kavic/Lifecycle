package com.kv.lifecycle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by tanjunzhao on 5/10/21.
 */
public class Util {

    public static <T> List<T> getSnapshot(Collection<T> other) {

        List<T> result = new ArrayList<T>(other.size());
        for (T item : other) {
            result.add(item);
        }

        return result;
    }

}
