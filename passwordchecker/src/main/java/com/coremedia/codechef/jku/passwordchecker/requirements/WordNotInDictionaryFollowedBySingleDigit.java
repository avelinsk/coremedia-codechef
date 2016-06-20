package com.coremedia.codechef.jku.passwordchecker.requirements;

import com.coremedia.codechef.jku.passwordchecker.Dictionary;
import com.coremedia.codechef.jku.passwordchecker.Requirement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Requirement: Password is not a word in the dictionary followed by a digit 0-9 (e.g., `hello5`).
 */
public class WordNotInDictionaryFollowedBySingleDigit implements Requirement {

  private static final Pattern PATTERN = Pattern.compile("(\\D+)\\d");

  private final Dictionary dictionary;

  public WordNotInDictionaryFollowedBySingleDigit(Dictionary dictionary) {
    this.dictionary = dictionary;
  }

  @Override
  public boolean check(String password) {
    Matcher matcher = PATTERN.matcher(password);

    if (!matcher.matches()) {
      return true;
    }

    String word = matcher.group(1);

    return !dictionary.contains(word);
  }
}
