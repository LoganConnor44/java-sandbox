package loganconnor44.pojo;

public class NodeList {
    public Node head;
    public int size = 0;
    
    public NodeList() {        
    }

    public NodeList(int value) {
        this.head = new Node(value);
        this.size++;
    }

    public int getAtIndex(int index) {
        Node desiredNode = new Node(-1);
        Node iterationNode = this.head;

        if (index < 0 || index > this.size - 1) {
            return desiredNode.value;
        }

        for (int i = 0; i < index; i++) {
            iterationNode = iterationNode.next;
        }
        desiredNode = iterationNode;

        return desiredNode.value;
    }

    public void addToHead(int value) {
        Node newHead = new Node(value);
        newHead.next = this.head;
        this.head = newHead;
        this.size++;
    }

    public void addAtIndex(int index, int value) {
        if (index < 0) {
            index = 0;
        }
        if (index == 0) {
            this.addToHead(value);
            return;
        } else if (index == this.size) {
            this.addToTail(value);
        } else if (index > this.size) {
            return;
        }

        Node iterationNode = this.head;
        for (int i = 0; i < this.size; i++) {
            if (index - 1 == i) {
                Node newNode = new Node(value);
                if (iterationNode.next != null) {
                    newNode.next = iterationNode.next;
                }
                iterationNode.next = newNode;
            }
        }
        
        this.size++;
    }

    public void addToTail(int value) {
        if (this.size < 1) {
            this.addToHead(value);
            return;
        }

        Node iterationNode = this.head;
        while (iterationNode.next != null) {
            iterationNode = iterationNode.next;
        }

        iterationNode.next = new Node(value);
        this.size++;
    }

    public void deleteAtIndex(int index) {
        if (index > this.size - 1) {
            return;
        }

        if (index == 0) {
            this.head = this.head.next;
            return;
        }

        Node iterationNode = this.head;
        for (int i = 0; i < this.size; i++) {
            if (index - 1 == i) {
                if (iterationNode.next.next == null) {
                    iterationNode.next = null;
                } else {
                    iterationNode.next = iterationNode.next.next;
                }
                return;
            }
            iterationNode = iterationNode.next; 
        }
    }

    public void removeLast() {
        Node iterationNode = this.head;
        Node secondToLast = iterationNode;

        if (this.size == 0) {
            return;
        } else if (this.size == 1) {
            this.head = null;
            this.size--;
        }

        while (iterationNode.next.next != null) {
            iterationNode = iterationNode.next; 
        }

        secondToLast.next = null;
        this.size--;
    }

}
