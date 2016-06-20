package com.coremedia.codechef.jku.passwordchecker;

import com.google.common.collect.ImmutableSet;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class DictionaryTest {

  @Test(dataProvider = "createData")
  public void testContains(String word, boolean expected) {
    Set<String> words = ImmutableSet.of("hund", "katze", "maus");
    Dictionary dictionary = Dictionary.from(words);

    assertThat(dictionary.contains(word)).isEqualTo(expected);
  }

  @DataProvider
  private Object[][] createData() {
    return new Object[][]{
            {"elefant", false},
            {"hund"   , true },
            {"dackel" , false},
            {"katze"  , true },
            {"maus"   , true },
            {"ratte"  , false},
    };
  }
}