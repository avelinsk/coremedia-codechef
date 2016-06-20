package com.coremedia.codechef.jku.passwordchecker.requirements;

import com.coremedia.codechef.jku.passwordchecker.Requirement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AtLeast8CharsTest {

  @Test(dataProvider = "createData")
  public void testCheck(String password, boolean expected) {
    Requirement requirement = new AtLeast8Chars();

    assertThat(requirement.check(password)).isEqualTo(expected);
  }

  @DataProvider
  private Object[][] createData() {
    return new Object[][]{
            {"123456"   , false},
            {"1234567"  , false},
            {"12345678" , true },
            {"123456789", true },
    };
  }
}