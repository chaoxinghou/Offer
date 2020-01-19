package com.houcx.test.linklist;

/**
 * 1. 判断一个链表是否存在环儿<br>
 * 2. 如果有环儿计算环儿的长度<br>
 * 3. 找出环儿的连接点<br>
 *
 * @author weijielu
 */
public class LinkedListLoop {

    /**
     * 判断一个链表是否存在环儿
     *
     * @param header
     * @return 是否存在环儿
     */
    public static boolean isExistLoop(Node header) {
        // 定义两个指针fast和slow,fast移动步长为2，slow移动步长为1
        Node fast = header;
        Node slow = header;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            //如果相遇则存在环儿，跳出
            if (fast == slow) {
                break;
            }
        }

        // 根据跳出循环的条件return
        if (fast == null || fast.next == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 计算有环儿链表的环儿长度<br>
     * fast, slow从碰撞点出发再次碰撞就是环儿的长度
     *
     * @param header
     * @return 返回环儿的长度
     */
    public static int loopLength(Node header) {
        // 如果不存在环儿，返回0
        if (!isExistLoop(header)) {
            return 0;
        }

        Node fast = header;
        Node slow = header;
        int length = 0;
        boolean begin = false;
        boolean again = false;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            // 超过两圈后停止计数，跳出循环
            if (fast == slow && again == true) {
                break;
            }

            // 超过一圈后开始计数
            if (fast == slow && again == false) {
                begin = true;
                again = true;
            }

            if (begin == true) {
                ++length;
            }
        }

        return length;
    }

    /**
     * 找出环儿的连接点<br>
     * 碰撞点到连接点的距离=头指针到连接点的距离<br>
     * 因此，分别从碰撞点、头指针开始走，相遇的那个点就是连接点<br>
     *
     * @param header
     * @return 环儿连接点
     */
    public static Node findLoopEntrance(Node header) {
        Node fast = header;
        Node slow = header;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        slow = header;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        Node<Integer> node1 = new Node<Integer>(2);
        Node<Integer> node2 = new Node<Integer>(2);
        Node<Integer> node3 = new Node<Integer>(3);
        Node<Integer> node4 = new Node<Integer>(4);
        Node<Integer> node5 = new Node<Integer>(10086);
        Node<Integer> node6 = new Node<Integer>(5);
        Node<Integer> node7 = new Node<Integer>(6);
        Node<Integer> node8 = new Node<Integer>(7);
        Node<Integer> node9 = new Node<Integer>(8);
        Node<Integer> node10 = new Node<Integer>(9);
        Node<Integer> node11 = new Node<Integer>(10);
        Node<Integer> node12 = new Node<Integer>(11);
        Node<Integer> node13 = new Node<Integer>(12);
        Node<Integer> node14 = new Node<Integer>(13);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;
        node10.next = node11;
        node11.next = node12;
        node12.next = node13;
        node13.next = node14;
        node14.next = node5;


        Node<Integer> head = node1;
        int s = 20;
        while (node1 != null && (s--) > 0) {
            System.out.print(node1.data + " ");
            node1 = node1.next;
        }

        if (isExistLoop(head)) {
            System.out.println("\n\n\nExist Loop of this LinkedList! \n\n\nAnd the length of the Loop is : [ " + loopLength(head) + " ] and the Linked-Node is " + findLoopEntrance(head).data);
        }

        node1 = head;
    }
}