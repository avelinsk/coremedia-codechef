package com.coremedia.codechef.jku.passwordchecker.requirements;

import com.coremedia.codechef.jku.passwordchecker.Requirement;

/**
 * Requirement: Password is at least 8 characters long.
 */
public class AtLeast8Chars implements Requirement {

  @Override
  public boolean check(String password) {
    return password.length() >= 8;
  }
}
