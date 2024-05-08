import java.io.*;
import java.util.*;
public class Main {
    static int[][] map, dp;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    static int m, n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[m][n];
        dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int result = back(m-1, n-1);

        //디버깅 코드
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                sb.append(dp[i][j]).append(" ");
//            }
//            sb.append("\n");
//        }
//        System.out.println("-----------dp------------");
//        System.out.println(sb);
//        System.out.println("result: "+result);
        //---------------------------------------------------

        System.out.println(result);

    }
    static int back(int x, int y) {
        if (x == 0 && y == 0) {
            return 1;
        }
        if (dp[x][y] == -1) return 0;
        if (dp[x][y] == 0) {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    if (map[nx][ny] > map[x][y]) {
                        dp[x][y] += back(nx, ny);
                    }
                }
            }
            if (dp[x][y] == 0) {
                dp[x][y] = -1;
                return 0;
            }
        }
        return dp[x][y];
    }
}
