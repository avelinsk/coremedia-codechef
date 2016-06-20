package com.coremedia.codechef.jku.passwordchecker.requirements;

import com.coremedia.codechef.jku.passwordchecker.Dictionary;
import com.coremedia.codechef.jku.passwordchecker.Requirement;

/**
 * Requirement: Password is not a word in the dictionary.
 */
public class NotInDictionary implements Requirement {

  private final Dictionary dictionary;

  public NotInDictionary(Dictionary dictionary) {
    this.dictionary = dictionary;
  }

  @Override
  public boolean check(String password) {
    return !dictionary.contains(password);
  }
}
