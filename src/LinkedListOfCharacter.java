import java.util.*;

public class LinkedListOfCharacter {
    private Node head;
    private Node tail;
    private Node current;
    private int count;

    private class Node {

        public Character element;
        public Node next;
        public LinkedList<Character> internListRef;

        public Node(Character element) {
            this.element = element;
            next = null;
        }

        public Node(Character element, Node next) {
            this.element = element;
            this.next = next;
        }

        public boolean isInternListEmpty() {
            if (internListRef == null || internListRef.size() == 0) {
                return true;
            }
            return false;
        }

    }

    public LinkedListOfCharacter() {
        head = null;
        tail = null;
        count = 0;
    }

    public int size() {
        return count;
    }

    public int add(Character element) {
        Node n = new Node(element);
        if (tail != null && tail.element == element) {
            if (tail.internListRef == null) {
                LinkedList<Character> internList = new LinkedList<>();
                internList.add(element);
                tail.internListRef = internList;
            } else {
                tail.internListRef.add(element);
            }
            return 1;

        } else {
            if (head == null) {
                head = n;
            } else {
                tail.next = n;
            }
            tail = n;
            count++;
        }
        return 0;
    }

    public Character next() {
        Character numPosCurrent = null;
        if (current != null) {
            numPosCurrent = current.element;
            current = current.next;
            return numPosCurrent;
        }
        return null;
    }

    public Character get(int index) {
        if (index == count - 1) {
            return tail.element;
        }

        Node aux = head;
        int c = 0;
        while (c < index) {
            aux = aux.next;
            c++;
        }
        return (aux.element);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        Node aux = head;

        while (aux != null) {
            s.append(aux.element.toString());
            if (!aux.isInternListEmpty()) {
                for (int i = 0; i < aux.internListRef.size(); i++) {
                    s.append(aux.internListRef.get(i));

                }
            }
            aux = aux.next;
        }

        return s.toString();
    }

    public void removeByIndex(int index) {
        if (index == 0) {
            if (head.isInternListEmpty()) {
                head = head.next;
                count--;
                return;

            } else if (!(head.isInternListEmpty())) {
                head.internListRef.remove();
                return;
            }
        } else {
            Node ant = head;
            for (int i = 0; i < index - 1; i++) {
                ant = ant.next;
            }

            if (ant.next.isInternListEmpty()) {
                if (index == count - 1) {
                    tail = ant;
                    tail.next = null;
                } else {
                    ant.next = ant.next.next;

                }
                count--;
                return;
            }

            else {
                ant.next.internListRef.remove();

            }
            return;
        }
    }

}
