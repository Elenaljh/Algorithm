import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            int n = Integer.parseInt(br.readLine());
            long[] prices = new long[n];
            long[] maxPrice = new long[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                prices[i] = Integer.parseInt(st.nextToken());
            }
            long max = 0;
            for (int i = n-1; i >= 0; i--) {
                max = Long.max(max, prices[i]);
                maxPrice[i] = max;
            }
            long sum = 0;
            for (int i = 0; i < n; i++) {
                sum += maxPrice[i] - prices[i];
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}