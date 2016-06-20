package com.coremedia.codechef.jku.passwordchecker;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;

public class Dictionary {

  private final Set<String> words;

  private Dictionary(Set<String> words) {
    this.words = words;
  }

  public boolean contains(String word) {
    return words.contains(word);
  }

  /**
   * Create a dictionary instance with words given directly.
   * <p>
   * Originally intended for testing purposes.
   */
  public static Dictionary from(Set<String> words) {
    return new Dictionary(words);
  }

  /**
   * Create a dictionary instance with words read from the path.
   */
  public static Dictionary from(Path path) throws IOException {
    Set<String> words = readWords(path);
    return new Dictionary(words);
  }

  /**
   * Read words from a file, trimming them and skipping empty lines.
   */
  private static Set<String> readWords(Path path) throws IOException {
    try (Stream<String> lineStream = Files.lines(path)) {
      return lineStream
              .map(String::trim)
              .filter(line -> !line.isEmpty())
              .collect(toSet());
    }
  }
}
