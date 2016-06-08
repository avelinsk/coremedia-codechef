package com.coremedia.dojo.chop;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ChopTest {
  @Test
  public void testEverything() {
    assertEquals(-1, chop(3, new ArrayList<>(Arrays.<Integer>asList())));
    assertEquals(-1, chop(3, new ArrayList<>(Arrays.<Integer>asList(1))));
    assertEquals(0,  chop(1, new ArrayList<>(Arrays.<Integer>asList(1))));
    assertEquals(0,  chop(1, new ArrayList<>(Arrays.<Integer>asList(1, 3, 5))));
    assertEquals(1,  chop(3, new ArrayList<>(Arrays.<Integer>asList(1, 3, 5))));
    assertEquals(2,  chop(5, new ArrayList<>(Arrays.<Integer>asList(1, 3, 5))));
    assertEquals(-1, chop(0, new ArrayList<>(Arrays.<Integer>asList(1, 3, 5))));
    assertEquals(-1, chop(2, new ArrayList<>(Arrays.<Integer>asList(1, 3, 5))));
    assertEquals(-1, chop(4, new ArrayList<>(Arrays.<Integer>asList(1, 3, 5))));
    assertEquals(-1, chop(6, new ArrayList<>(Arrays.<Integer>asList(1, 3, 5))));
    assertEquals(0,  chop(1, new ArrayList<>(Arrays.<Integer>asList(1, 3, 5, 7))));
    assertEquals(1,  chop(3, new ArrayList<>(Arrays.<Integer>asList(1, 3, 5, 7))));
    assertEquals(2,  chop(5, new ArrayList<>(Arrays.<Integer>asList(1, 3, 5, 7))));
    assertEquals(3,  chop(7, new ArrayList<>(Arrays.<Integer>asList(1, 3, 5, 7))));
    assertEquals(-1, chop(0, new ArrayList<>(Arrays.<Integer>asList(1, 3, 5, 7))));
    assertEquals(-1, chop(2, new ArrayList<>(Arrays.<Integer>asList(1, 3, 5, 7))));
    assertEquals(-1, chop(4, new ArrayList<>(Arrays.<Integer>asList(1, 3, 5, 7))));
    assertEquals(-1, chop(6, new ArrayList<>(Arrays.<Integer>asList(1, 3, 5, 7))));
    assertEquals(-1, chop(8, new ArrayList<>(Arrays.<Integer>asList(1, 3, 5, 7))));
  }

  private int chop(int value, List<Integer> values) {
    //return BinarySearch.search(candidate, values);
    //return BinarySearch.search2(value, values);
    return BinarySearch.search3(value, values);
  }
}