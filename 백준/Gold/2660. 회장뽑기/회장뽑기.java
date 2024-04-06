import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int MAX_VAL = 10_000_000;
        int[][] graph = new int[n+1][n+1];
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            if (first == -1) break;
            graph[first][second] = 1;
            graph[second][first] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i!=j && graph[i][j] == 0) {
                    graph[i][j] = MAX_VAL;
                }
            }
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    graph[i][j] = Integer.min(graph[i][j], graph[i][k]+graph[k][j]);
                }
            }
        }

        List<Integer> scores = new ArrayList<>();
        scores.add(MAX_VAL);
        for (int i = 1; i <= n; i++) {
            int[] tmp = graph[i];
            Arrays.sort(tmp);
            scores.add(tmp[n]);
        }

        int minScore = Collections.min(scores);
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (scores.get(i) == minScore) {
                count++;
                sb1.append(i).append(" ");
            }
        }
        sb.append(minScore).append(" ").append(count);
        System.out.println(sb);
        System.out.println(sb1);
    }
}