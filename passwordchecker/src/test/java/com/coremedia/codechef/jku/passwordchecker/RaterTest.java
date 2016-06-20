package com.coremedia.codechef.jku.passwordchecker;

import com.google.common.collect.ImmutableSet;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class RaterTest {

  @Test(dataProvider = "createData")
  public void testCheck(String password, Rating expected) {
    Set<String> words = ImmutableSet.of("hund", "katze", "maus", "rennmaus");
    Dictionary dictionary = Dictionary.from(words);

    Rater rater = new Rater(dictionary);
    assertThat(rater.rate(password)).isEqualTo(expected);
  }

  @DataProvider
  private Object[][] createData() {
    return new Object[][]{
            {"12345678"     , Rating.GOOD},
            {"elefant"      , Rating.BAD }, // word not in dictionary, but too short
            {"rennmaus"     , Rating.BAD }, // long enough, but word in dictionary
            {"rennmaus5"    , Rating.BAD }, // long enough, but word in dictionary followed by single digit
            {"rennschnecke5", Rating.GOOD},
            {"hund5hase"    , Rating.BAD }, // long enough, but first word in dictionary
            {"dachs7katze"  , Rating.BAD }, // long enough, but second word in dictionary
            {"dachs3hase"   , Rating.GOOD},
            {"dachsdachs"   , Rating.GOOD},
    };
  }
}