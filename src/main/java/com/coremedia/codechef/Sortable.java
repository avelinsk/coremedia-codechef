package com.coremedia.codechef;

import java.util.List;

public interface Sortable<T> {

  public void add(T element);

  public List<T> getElements();
}
