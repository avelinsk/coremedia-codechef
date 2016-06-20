package com.coremedia.codechef.jku.passwordchecker.requirements;

import com.coremedia.codechef.jku.passwordchecker.Dictionary;
import com.coremedia.codechef.jku.passwordchecker.Requirement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Requirement: Password is not two words separated by a digit (e.g., `hello2world`).
 */
public class WordsNotInDictionarySeparatedBySingleDigit implements Requirement {

  private static final Pattern PATTERN = Pattern.compile("(\\D+)\\d(\\D+)");

  private final Dictionary dictionary;

  public WordsNotInDictionarySeparatedBySingleDigit(Dictionary dictionary) {
    this.dictionary = dictionary;
  }

  @Override
  public boolean check(String password) {
    Matcher matcher = PATTERN.matcher(password);

    if (!matcher.matches()) {
      return true;
    }

    String word1 = matcher.group(1);
    String word2 = matcher.group(2);

    return !dictionary.contains(word1) && !dictionary.contains(word2);
  }
}
