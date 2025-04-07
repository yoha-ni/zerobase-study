package dev.yoha_ni.study.two_month.week5.day2;

public class LinkedList {

    public static class CustomLinkedList {
        private static class Node {
            int value;
            Node pointer;

            public Node(int value) {
                this.value = value;
                this.pointer = null;
            }
        }

        private Node head;
        private int size;

        public CustomLinkedList() {
            this.size = 0;
        }

        public void add(int value) {
            if (head == null) {
                head = new Node(value);
            } else {
                Node current = head;

                while (current.pointer != null) {
                    current = current.pointer;
                }

                current.pointer = new Node(value);
            }
            size++;
        }

        public void add(int index, int value) {
            // 인덱스 유효범위

            Node newNode = new Node(value);

            if (index == 0) {
                // 새로운 값이 head가 될때
                newNode.pointer = head;
            }
        }

        public void remove() {
            Node current = head;

            while (current.pointer != null) {

                if (current.pointer.pointer != null) {
                    current = current.pointer;
                } else {
                    current.pointer = null;
                    size--;
                    break;
                }

            }
        }

        public int get(int index){
            // 인덱스의 유효 범위 체크
//            Node current = head;
//            for (int i = 0; i < size; i++) {
//                if(i == index) return current.value;
//                current = current.pointer;
//            }
//            return -1;
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.pointer;
            }
            return current.value;
        }

        public void print() {
            StringBuffer sb = new StringBuffer();
            sb.append("[");
            Node current = head;
            while (true) {
                sb.append(current.value);
                if (current.pointer != null) sb.append(", ");
                current = current.pointer;
                if (current == null) break;
            }
            sb.append("]");
            System.out.println(sb.toString());
        }
    }

    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList();
        list.add(10);
        list.add(20);
        list.add(30);
        list.print();

        list.remove();
        list.print();

    }
}
