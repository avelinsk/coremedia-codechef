package com.coremedia.codechef.ahu.binarytreeboundary;

import org.junit.Test;

import static org.junit.Assert.*;

public class ComputeBoundaryTest {

  @Test
  public void testExample() {
    Node<Integer> tree = tree();
    String result = ComputeBoundary.computeBoundaryString(tree);
    assertEquals("20 8 4 10 14 25 22", result);
  }

  @Test
  public void testSum() {
    // we can use the Java 8 Streams API to compute other things for all boundary nodes. Just for fun:
    ComputeBoundary.computeBoundary(tree())
            .stream()
            .map(Node::getData)
            .reduce(Integer::sum)
            .ifPresent(System.out::print);
  }

  @Test
  public void testNull() {
    assertEquals("", ComputeBoundary.computeBoundaryString(null));
  }

  private static Node<Integer> tree() {
    // would be nice to have a Builder for trees
    return new Node<>(20,
            new Node<>(8,
                    new Node<>(4),
                    new Node<>(12,
                            new Node<>(10),
                            new Node<>(14))),
            new Node<>(22,
                    null,
                    new Node<>(25)));
  }


}