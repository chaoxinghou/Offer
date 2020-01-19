package com.houcx.test;

/**
 * 链表逆置
 */
public class ChainReversed {
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);

        a.nextNote = b;
        b.nextNote = c;
        c.nextNote = d;
        printChain(a);
        reverseChainNotRecursive(a);
        printChain(d);
    }

    private static Node reverseChainRecursive(Node node) {
        System.out.println("before " + node);
        if (node == null || node.nextNote == null) {
            System.out.println("after " + node);
            return node;
        }

        Node headOfReverseChain = reverseChainRecursive(node.nextNote);
        node.nextNote.nextNote = node;
        node.nextNote = null;
        return headOfReverseChain;
    }


    private static void printChain(Node node) {
        System.out.println("=============>node:" + node.value);
        if (node.nextNote != null) {
            printChain(node.nextNote);
        }
    }

    private static Node reverseChainNotRecursive(Node node) {
        Node pre = node;
        Node cur = node.nextNote;
        Node tmp;
        // 头结点的nextNode应该要置空
        pre.nextNote = null;
        while (cur != null) {
            //先存放next结点
            tmp = cur.nextNote;
            // 修改next结点指向pre
            cur.nextNote = pre;
            System.out.println("not ready " + tmp);
            System.out.println("already " + cur);
            System.out.println("----------");
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

}