package io.github.ranolp.typia.util;

import java.util.*;
import java.util.function.Predicate;

public final class Tree<T> {
    private final boolean root;
    private final Set<Tree<T>> children;
    private final T value;

    private Tree(boolean root, T value, Collection<Tree<T>> children) {
        if (!root && value == null) {
            throw new IllegalArgumentException("Child tree must have value");
        }
        if (root) {
            if (value != null) {
                throw new IllegalArgumentException("Root tree must not have value");
            }
        }
        this.root = root;
        this.value = value;
        this.children = children != null ? new HashSet<>(children) : Collections.emptySet();
    }

    public boolean isRoot() {
        return root;
    }

    public T getValue() {
        if (root) {
            throw new IllegalStateException("Root tree does not have any value");
        }
        return value;
    }

    public boolean hasValue() {
        return !root && value != null;
    }

    public Set<Tree<T>> getChildren() {
        return new HashSet<>(children);
    }

    public boolean hasChildren() {
        return !children.isEmpty();
    }

    public Optional<Tree<T>> findFirst(Predicate<Tree<T>> predicate) {
        return getChildren().stream().filter(predicate).findFirst();
    }

    public Tree<T> root(Tree<T>... children) {
        return new Tree<>(true, null, Arrays.asList(children));
    }

    public Tree<T> child(T value, Tree<T>... children) {
        return new Tree<>(false, value, Arrays.asList(children));
    }
}
