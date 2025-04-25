package dev.yoha_ni.study.two_month.week7.day5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node{
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class BFSExample {

    public static void main(String[] args) {
        int N = 7;

        List<Node> nodes = new ArrayList<>(); // 노드를 저장할 리스트 만들었음
        for (int i = 0; i < N; i++) {
            nodes.add(new Node(i)); // 노드 저장 리스트에 자식 노드가 없는 노드들을 0 ~ 6까지 저장함
        }

        Node root = nodes.get(0); // root를 리스트에 노드 0번으로 지정함

        for (int current = 0; current <= (N - 1) / 2; current++) { // (N-1)/2까지만 반복하는 이유는, 그 이후 노드들은 리프 노드라 자식이 없기 때문.
            int left = current * 2 + 1; // 현재 노드의 왼쪽 자식노드 지정 (1)
            int right = current * 2 + 2; // 현재 노드의 오른쪽 자식 노드 지정 (2)

            if (left < N) { // 1 < 7 true
                nodes.get(current).left = nodes.get(left); // 리스트에(0) 왼쪽에 자식노드 지정
            }

            if (right < N) { // 2 < 7 true
                nodes.get(current).right = nodes.get(right); // 리스트에(0) 오른쪽에 자식노드 지정
            }
        } // 트리구조 완성

        List<Integer> result = new ArrayList<>(); // 결과값 저장할 리스트
        Queue<Node> queue = new LinkedList<>(); // BFS는 자료구조 큐로 사용
        queue.add(root);

        while (!queue.isEmpty()) { // 큐에 비어있지 않을때
            Node node = queue.poll(); // node는 큐에서 하나 빼가지고
            result.add(node.value); // 결과값 리스트에 지금 노드의 value값을 저장

            if (node.left != null) { // 지금 저장한 노드에 왼쪽에 값이 있다면. 큐에 왼쪽 노드 저장
                queue.add(node.left);
            }

            if (node.right != null) {  // 지금 저장한 노드에 오른쪽에 값이 있다면. 큐에 오른쪽노드 저장
                queue.add(node.right);
            }
        }

        System.out.println(result);

    }

}
