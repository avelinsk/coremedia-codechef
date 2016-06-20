package com.coremedia.codechef.jku.passwordchecker;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Command-line entry point.
 */
public class Cli {

  private Cli() {
  }

  public static void main(String[] args) throws IOException {
    if (args.length != 2) {
      System.err.println("Usage: java " + Cli.class.getSimpleName() + " <dictionary filename> <password>");
      System.exit(1);
    }

    Path dictionaryPath = Paths.get(args[0]);
    String password = args[1];

    execute(dictionaryPath, password);
  }

  private static void execute(Path dictionaryPath, String password) throws IOException {
    Dictionary dictionary = Dictionary.from(dictionaryPath);

    Rater rater = new Rater(dictionary);
    rater.setRequirementCheckedHook(Cli::displayRequirementResult);

    System.out.println("Password: '" + password + "'\n");
    Rating rating = rater.rate(password);
    System.out.println("\nRating: " + rating);
  }

  private static void displayRequirementResult(Requirement requirement, boolean fulfilled) {
    String symbol = fulfilled ? "✔" : "✘";
    System.out.println(symbol + " " + requirement.getClass().getSimpleName());
  }
}
