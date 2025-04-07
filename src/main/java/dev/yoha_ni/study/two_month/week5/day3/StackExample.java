package dev.yoha_ni.study.two_month.week5.day3;

public class StackExample {

    public static class Stack{
        private int[] data;
        private int top;    // 최상위 데이터의 인덱스 값 1개 사용 위치
        private int size;

        public Stack() {
            this.size = 0;
            this.data = new int[10];
            top = -1;
        }

        public void push(int data) {
            if (isFull()) {
                System.out.println("Stack is Full");
                return;
            }
            this.data[++top] = data;
        }

        public void pop(){
            if (isEmpty()) {
                System.out.println("Stack is Empty");
                return;
            }
            this.top--;
            this.size--;
        }

        public int peek(){
            if (isEmpty()) {
                System.out.println("Stack is Empty");
                return -1;
            }
            return data[top];
        }

        public boolean isEmpty(){
            if (top == -1) {
                return true;
            }
            return false;
        }

        public boolean isFull(){
            return top == data.length - 1;
        }


        public void printStack(){
            if (isEmpty()) {
                System.out.println("Stack이 빈값 입니다.");
                return;
            }
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i <= top; i++) {
                sb.append(data[i]).append(" ");
            }
            System.out.println(sb.toString());
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.printStack();

        System.out.println(stack.isEmpty());
        System.out.println(stack.isFull());
        System.out.println(stack.peek());

    }
}
