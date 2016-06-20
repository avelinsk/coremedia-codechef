package com.coremedia.codechef.jku.passwordchecker.requirements;

import com.coremedia.codechef.jku.passwordchecker.Requirement;
import com.coremedia.codechef.jku.passwordchecker.Dictionary;
import com.google.common.collect.ImmutableSet;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class WordsNotInDictionarySeparatedBySingleDigitTest {


  @Test(dataProvider = "createData")
  public void testCheck(String password, boolean expected) {
    Set<String> words = ImmutableSet.of("hund", "katze", "maus");
    Dictionary dictionary = Dictionary.from(words);

    Requirement requirement = new WordsNotInDictionarySeparatedBySingleDigit(dictionary);

    assertThat(requirement.check(password)).isEqualTo(expected);
  }

  @DataProvider
  private Object[][] createData() {
    return new Object[][]{
            {"elefant4elefant", true }, // word not in dictionary
            {"elefant4katze"  , false}, // one word (second) in dictionary
            {"hund3kamel"     , false}, // one word (first) in dictionary
            {"hund4katze"     , false}, // both words in dictionary
            {"hund katze"     , true }, // no digit
            {"hund2katze"     , false},
            {"hund22katze"    , true }, // more than a single digit
            {"katze9katze9"   , true },
    };
  }
}