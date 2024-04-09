import java.io.*;
import java.util.*;
public class Main {
    static boolean[] visited;
    static List<List<Integer>> network;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        network = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            network.add(new ArrayList<>());
        }
        visited = new boolean[n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            network.get(first).add(second);
            network.get(second).add(first);
        }

        bfs();

        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (visited[i]) count++;
        }
        System.out.println(count);
    }

    static void bfs() {
        visited[1] = true;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        while (!q.isEmpty()) {
            Integer computer = q.poll();
            List<Integer> list = network.get(computer);
            for (Integer next : list) {
                if (!visited[next]){
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
    }
}