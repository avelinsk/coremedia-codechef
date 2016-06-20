package com.coremedia.codechef.jku.passwordchecker.requirements;

import com.coremedia.codechef.jku.passwordchecker.Dictionary;
import com.coremedia.codechef.jku.passwordchecker.Requirement;
import com.google.common.collect.ImmutableSet;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class WordNotInDictionaryFollowedBySingleDigitTest {

  @Test(dataProvider = "createData")
  public void testCheck(String password, boolean expected) {
    Set<String> words = ImmutableSet.of("hund", "katze", "maus");
    Dictionary dictionary = Dictionary.from(words);

    Requirement requirement = new WordNotInDictionaryFollowedBySingleDigit(dictionary);

    assertThat(requirement.check(password)).isEqualTo(expected);
  }

  @DataProvider
  private Object[][] createData() {
    return new Object[][]{
            {"elefant"     , true }, // word not in dictionary
            {"elefant4"    , true }, // word not in dictionary
            {"elefant42"   , true }, // word not in dictionary
            {"hund"        , true }, // no digit
            {"hund0"       , false},
            {"hund1"       , false},
            {"katze"       , true }, // no digit
            {"katze9"      , false},
            {"katze99"     , true }, // more than a single digit
            {"katze9katze" , true }, // more than one word
            {"katzekatze9" , true }, // word not in dictionary
            {"katze9katze9", true }, // more than one word, more than a single digit
    };
  }
}