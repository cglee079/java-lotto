package com.zuniorteam.lotto.util;

import java.util.Collection;

public class CollectionUtils {

    public static <T> boolean isUnique(Collection<T> collection) {
        return collection.stream().distinct().count() == collection.size();
    }
}
