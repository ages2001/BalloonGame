public class CircularLinkedList {
    public static class Node {
        private int data;
        private Node next;

        public int getData() {
            return this.data;
        }

        public Node getNext() {
            return this.next;
        }

        public void setData(int data) {
            this.data = data;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node(int data, Node next) {
            setData(data);
            setNext(next);
        }
    }

    private Node head;

    public Node getHead() {
        return this.head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public CircularLinkedList(int N) {
        Node headNode = new Node(1, null);
        headNode.setNext(headNode);

        setHead(headNode);

        for (int i = 2; i <= N; i++) {
            Node prevNode = getHead();
            while (prevNode.getNext() != getHead()) {
                prevNode = prevNode.getNext();
            }

            Node newNode = new Node(i, getHead());
            prevNode.setNext(newNode);
        }
    }

    public Node remove(int K) {
        Node continueNode = null;

        while (getHead().getNext() != getHead()) {
            int count = continueNode == null ? K - 1 : K - 2;

            Node current = continueNode != null ? continueNode : getHead();

            for (int i = 0; i < count; i++)
                current = current.getNext();

            boolean wasHead = current == getHead();

            Node prevNode = getHead();

            while (prevNode.getNext() != current)
                prevNode = prevNode.getNext();

            if (wasHead) setHead(current.getNext());

            prevNode.setNext(current.getNext());
            continueNode = current.getNext();

            current.setNext(null);
        }
        return getHead();
    }
}
