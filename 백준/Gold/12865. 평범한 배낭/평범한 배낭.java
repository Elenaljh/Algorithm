import java.io.*;
import java.util.*;
public class Main {
    static int dp[][], input[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        dp = new int[n+1][k+1];
        input = new int[2][n+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            input[0][i] = Integer.parseInt(st.nextToken()); //무게
            input[1][i] = Integer.parseInt(st.nextToken()); //가치
        }

        System.out.println(knapsack(n, k));
    }

    static int knapsack(int n, int k) {
        if (n == 0) {
            return 0;
        }
        if (dp[n][k] == 0) {
            if (input[0][n] > k) {
                dp[n][k] = knapsack(n-1, k);
            } else {
                dp[n][k] = Math.max(knapsack(n-1, k), knapsack(n-1, k-input[0][n])+input[1][n]);
            }
        }
        return dp[n][k];
    }
}