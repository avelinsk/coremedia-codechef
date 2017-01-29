package com.coremedia.codechef;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Message implements Sortable<String> {

  private int[] hits = new int[26];
  private final String alphabet = "abcdefghijklmnopqrstuvwxyz";

  public void add(String element) {
    if (StringUtils.isNotEmpty(element)) {
      char[] lowerCaseChars = element.toLowerCase().toCharArray();
      for (char lowerCaseChar : lowerCaseChars) {
        if (Character.isLowerCase(lowerCaseChar)) {
          hits[alphabet.indexOf(lowerCaseChar)] += 1;
        }
      }
    }
  }

  public List<String> getElements() {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < 26; i++) {
      int count = hits[i];
      while (count > 0) {
        char c = alphabet.charAt(i);
        stringBuilder.append(c);
        count--;
      }
    }

    List<String> result = new ArrayList<String>();
    result.add(stringBuilder.toString());
    return result;
  }
}
