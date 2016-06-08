package com.coremedia.codechef.ahu.binarytreeboundary;

/**
 * A binary tree node that holds some data.
 *
 * @param <T> type of data in the node
 */
public class Node<T> {

  private final T data;
  private final Node<T> left;
  private final Node<T> right;

  /**
   * Creates a leaf node with data.
   *
   * @param data node data
   */
  public Node(T data) {
    this(data, null, null);
  }

  /**
   * @param data node data
   * @param left left child, possibly null
   * @param right right child, possibly null
   */
  public Node(T data, Node<T> left, Node<T> right) {
    this.data = data;
    this.left = left;
    this.right = right;
  }

  public T getData() {
    return data;
  }

  public Node<T> getLeft() {
    return left;
  }

  public Node<T> getRight() {
    return right;
  }

  /**
   * Returns whether this node is a leaf.
   *
   * <p>A leaf is a node without child nodes.
   *
   * @return whether this node is a leaf
   */
  public boolean isLeaf() {
    return left == null && right == null;
  }
}
