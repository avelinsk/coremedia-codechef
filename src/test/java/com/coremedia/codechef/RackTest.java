package com.coremedia.codechef;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RackTest {
  private Rack rack = new Rack();

  @Test
  public void testRack(){
    assertEquals(0, rack.getElements().size());

    rack.add(20);
    assertEquals(1, rack.getElements().size());
    assertEquals(20, ((int) rack.getElements().iterator().next()));

    rack.add(10);
    rack.add(30);
    List<Integer> result = rack.getElements();
    assertEquals(Arrays.asList(10, 20, 30), result);
  }
}