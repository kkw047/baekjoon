/*
문제
그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.

입력
첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.

출력
첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.
* */

import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();

        graph = new ArrayList[N + 1]; // N+1 (1 부터 시작이니깐)

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();

            graph[node1].add(node2);
            graph[node2].add(node1);
        }

        for (int i = 0; i <= N; i++) {
            Collections.sort(graph[i]);
        }
        visited = new boolean[N + 1];
        dfs(V);
        visited = new boolean[N + 1];
        bfs(V);
    }

    static void dfs(int start) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int current = stack.pop();

            if (!visited[current]) {  // 방문하지 않은 노드일 때만 처리
                visited[current] = true;
                System.out.print(current + " ");

                // 작은 번호부터 방문하기 위해 역순으로 스택에 추가
                for (int i = graph[current].size() - 1; i >= 0; i--) {
                    int next = graph[current].get(i);
                    if (!visited[next]) {
                        stack.push(next);
                    }
                }
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        visited[start] = true;
        System.out.print("\n");


        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (int next : graph[current]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }

    }
}



