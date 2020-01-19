package com.houcx.test;

public class Node {
    public Node nextNote;
    public int value;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "nextNote=" + nextNote +
                ", value=" + value +
                '}';
    }
}
