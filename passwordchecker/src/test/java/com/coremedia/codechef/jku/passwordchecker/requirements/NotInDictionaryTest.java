package com.coremedia.codechef.jku.passwordchecker.requirements;

import com.coremedia.codechef.jku.passwordchecker.Dictionary;
import com.coremedia.codechef.jku.passwordchecker.Requirement;
import com.google.common.collect.ImmutableSet;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class NotInDictionaryTest {

  @Test(dataProvider = "createData")
  public void testCheck(String password, boolean expected) {
    Set<String> words = ImmutableSet.of("hund", "katze", "maus");
    Dictionary dictionary = Dictionary.from(words);

    Requirement requirement = new NotInDictionary(dictionary);

    assertThat(requirement.check(password)).isEqualTo(expected);
  }

  @DataProvider
  private Object[][] createData() {
    return new Object[][]{
            {"elefant" , true },
            {"hund"    , false},
            {"hundhund", true },
            {"dackel"  , true },
            {"katze"   , false},
            {"maus"    , false},
            {"ratte"   , true },
    };
  }
}