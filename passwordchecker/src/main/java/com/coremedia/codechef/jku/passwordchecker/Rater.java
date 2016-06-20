package com.coremedia.codechef.jku.passwordchecker;

import com.coremedia.codechef.jku.passwordchecker.requirements.AtLeast8Chars;
import com.coremedia.codechef.jku.passwordchecker.requirements.WordNotInDictionaryFollowedBySingleDigit;
import com.coremedia.codechef.jku.passwordchecker.requirements.WordsNotInDictionarySeparatedBySingleDigit;
import com.coremedia.codechef.jku.passwordchecker.requirements.NotInDictionary;
import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.function.BiConsumer;

/**
 * Rate passwords using a list of requirements.
 */
public class Rater {

  private final Dictionary dictionary;

  /**
   * Optional hook to process intermediate requirement evaluation result.
   */
  private BiConsumer<Requirement, Boolean> requirementCheckedHook;

  public Rater(Dictionary dictionary) {
    this.dictionary = dictionary;
  }

  public void setRequirementCheckedHook(BiConsumer<Requirement, Boolean> requirementCheckedHook) {
    this.requirementCheckedHook = requirementCheckedHook;
  }

  public Rating rate(String password) {
    List<Requirement> requirements = prepareRequirements();
    boolean good = evaluateRequirements(requirements, password);
    return good ? Rating.GOOD : Rating.BAD;
  }

  private List<Requirement> prepareRequirements() {
    return ImmutableList.of(
            new AtLeast8Chars(),
            new NotInDictionary(dictionary),
            new WordNotInDictionaryFollowedBySingleDigit(dictionary),
            new WordsNotInDictionarySeparatedBySingleDigit(dictionary)
    );
  }

  /**
   * Evaluate password against all requirements and return a combined result.
   */
  private boolean evaluateRequirements(List<Requirement> requirements, String password) {
    return requirements
            .stream()
            .map(requirement -> {
              boolean fulfilled = requirement.check(password);
              executeRequirementCheckedHook(requirement, fulfilled);
              return fulfilled;
            })
            .allMatch(result -> result);
  }

  private void executeRequirementCheckedHook(Requirement requirement, boolean fulfilled) {
    if (requirementCheckedHook != null) {
      requirementCheckedHook.accept(requirement, fulfilled);
    }
  }
}
