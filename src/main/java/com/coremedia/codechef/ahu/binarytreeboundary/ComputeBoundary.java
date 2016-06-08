package com.coremedia.codechef.ahu.binarytreeboundary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Utility class to compute boundary nodes of a binary tree.
 */
public class ComputeBoundary {

  private ComputeBoundary() {
  }

  /**
   * Returns a string representation of the {@link #computeBoundary(Node) boundary nodes} of the given tree.
   *
   * <p>The result is a space-separated string with the {@link Node#getData() data} of all boundary nodes.
   *
   * @param node tree node
   * @param <T> type of data in tree node
   * @return string representation, empty string if node is null
   */
  public static <T> String computeBoundaryString(Node<T> node) {
    List<Node<T>> nodes = computeBoundary(node);
    return nodes.stream()
            .map(Node::getData)
            .map(String::valueOf)
            .collect(Collectors.joining(" "));
  }

  /**
   * Computes the anti-clockwise boundary nodes of the given binary tree node.
   *
   * <p>It starts with the node itself, followed by nodes on the left boundary from
   * the root to the leaves, followed by the leaf nodes from left to right, and lastly
   * followed by the nodes on the right boundary from the leaves up to the root node.
   *
   * <p>The returned list does not contain duplicate nodes.
   *
   * @param node tree node
   * @param <T> type of data in tree nodes
   * @return list of nodes at boundary, empty list if node is null
   */
  public static <T> List<Node<T>> computeBoundary(Node<T> node) {
    if (node == null) {
      return Collections.emptyList();
    }

    LinkedHashSet<Node<T>> result = new LinkedHashSet<>();
    addLeftBoundary(result, node);
    addLeaves(result, node);
    addRightBoundary(result, node);
    return new ArrayList<>(result);
  }

  private static <T> void addLeftBoundary(LinkedHashSet<Node<T>> result, Node<T> node) {
    result.add(node);
    if (node.getLeft() != null) {
      addLeftBoundary(result, node.getLeft());
    } else if (node.getRight() != null) {
      addLeftBoundary(result, node.getRight());
    }
  }

  private static <T> void addLeaves(LinkedHashSet<Node<T>> result, Node<T> node) {
    if (node.isLeaf()) {
      result.add(node);
    } else {
      if (node.getLeft() != null) {
        addLeaves(result, node.getLeft());
      }
      if (node.getRight() != null) {
        addLeaves(result, node.getRight());
      }
    }
  }

  private static <T> void addRightBoundary(LinkedHashSet<Node<T>> result, Node<T> node) {
    if (node.getRight() != null) {
      addRightBoundary(result, node.getRight());
    } else if (node.getLeft() != null) {
      addRightBoundary(result, node.getLeft());
    }
    result.add(node);
  }
}
