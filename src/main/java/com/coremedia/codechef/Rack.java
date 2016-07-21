package com.coremedia.codechef;

import java.util.ArrayList;
import java.util.List;

public class Rack implements Sortable<Integer>{

  private int [] elements = new int[60];

  public void add(Integer element) {
    elements[--element] += 1;
  }

  public List<Integer> getElements() {
    List<Integer> sortedElements = new ArrayList<>();
    for (int i=0; i < 60; i++) {
      if (elements[i] == 1) {
        sortedElements.add(i + 1);
      }
    }
    return sortedElements;
  }
}
