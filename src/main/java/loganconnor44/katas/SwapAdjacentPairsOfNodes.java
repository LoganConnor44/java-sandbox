package loganconnor44.katas;

import loganconnor44.pojo.*;

public class SwapAdjacentPairsOfNodes {

    public Node swapAdjacentRecursively(Node head) {

        //base case
        if (head == null || head.next == null) {
            return head;
        }

        //identify nodes to be swapped
        Node first = head;
        Node second = head.next;

        //complete swap and select the next node
        first.next = this.swapAdjacentRecursively(second.next);
        second.next = first;

        //return final product
        return second;
    }

    public Node swapAdjacentIteratively(Node head) {
        Node manager = new Node(0);
        manager.next = head;
        
        Node previous = manager;
        while (previous.next != null && previous.next.next != null) {
            Node first = previous.next;
            Node second = previous.next.next;

            this.swap(previous, first, second);

            previous = first;
            head = first.next;
        }

        return manager.next;
    }

    private void swap(Node previous, Node first, Node second) {
        previous.next = second;
        first.next = second.next;
        second.next = first;
    }
}
