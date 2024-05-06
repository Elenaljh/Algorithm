import java.io.*;
import java.util.*;
public class Main {
    static int[][][] dp;
    static int[] burgers, fries;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //주문
        int m = Integer.parseInt(st.nextToken()); //치즈버거
        int k = Integer.parseInt(st.nextToken()); //감자튀김

        burgers = new int[n+1];
        fries = new int[n+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            burgers[i] = Integer.parseInt(st.nextToken());
            fries[i] = Integer.parseInt(st.nextToken());
        }

        //n번째 주문을 받았을 때, 처리할 수 있는 가장 많은 주문
        //int[n][m][k] -> n번째 주문, 남은 치즈버거 m개, 남은 감튀 k개
        dp = new int[n+1][m+1][k+1];

        System.out.println(knapsack(n, m, k));
    }
    static int knapsack(int n, int m, int k) {
        if (n == 0 || k < 0 || m < 0) {
            return 0;
        }
        if (dp[n][m][k] == 0) {
            if (m < burgers[n] || k < fries[n]) {
                dp[n][m][k] = knapsack(n-1, m, k);
            } else {
                dp[n][m][k] = Math.max(knapsack(n-1, m, k), knapsack(n-1, m-burgers[n], k-fries[n]) + 1);
            }
        }
        return dp[n][m][k];

    }
}