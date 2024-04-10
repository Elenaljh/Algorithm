import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[][] graph = new boolean[n+1][n+1];

        //graph[i][j] = true : i가 j보다 무거움, j가 i보다 가벼움
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = true;
        }

        //플로이드 워셜
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    graph[i][j] = graph[i][j] || (graph[i][k] && graph[k][j]);
                }
            }
        }

        //어떤 구슬보다 무거운/가벼운 구슬이 n/2+1개 이상 있을 때 그 구슬은 절대 중간 무게가 될 수 없다
        //i를 기준으로 한다.
        int point = n/2+1;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int heavy = 0;
            int light = 0;
            for (int j = 1; j <= n; j++) {
                if (graph[i][j]) light++;
                if (graph[j][i]) heavy++;
                if (light >= point || heavy >= point) {
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}