package com.coremedia.codechef;

import java.util.List;

public interface Sortable<T> {

  void add(T element);

  List<T> getElements();
}
