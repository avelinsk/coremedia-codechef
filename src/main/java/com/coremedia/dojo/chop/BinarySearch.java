package com.coremedia.dojo.chop;

import java.util.Collections;
import java.util.List;

public class BinarySearch {

  public static int search(int value, List<Integer> values) {
    int start = 0;
    int end = values.size() - 1;

    while (start <= end) {
      int mid = (start + end) / 2;
      int midValue = values.get(mid);
      if (midValue < value) {
        start = mid + 1;
      } else if (midValue > value) {
        end = mid - 1;
      } else {
        return mid;
      }
    }

    return -1;
  }

  public static int search2(int value, List<Integer> values) {
    return Math.max(-1, Collections.binarySearch(values, value));
  }

  public static int search3(int value, List<Integer> values) {
    if (values.isEmpty()) {
      return -1;
    } else {
      int mid = values.size() / 2;
      int midValue = values.get(mid);
      if (midValue < value) {
        int partialResult = search3(value, values.subList(mid + 1, values.size()));
        return partialResult == -1 ? -1 : mid + 1 + partialResult;
      } else if (midValue > value) {
        return search3(value, values.subList(0, mid));
      } else {
        return mid;
      }
    }
  }
}