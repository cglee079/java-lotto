package com.zuniorteam.lotto.util;

import java.util.*;

public class CollectionUtil {

    public static <T> boolean isUnique(Collection<T> collection) {
        return collection.stream().distinct().count() == collection.size();
    }

    public static <T> List<T> merge(List<T> base, List<T> another) {
        final ArrayList<T> newBases = new ArrayList<>(base);
        newBases.addAll(another);
        return newBases;
    }
}
