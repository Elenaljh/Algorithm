import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] times = new int[n];
        for (int i = 0; i < n; i++) {
            times[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(times);
        int[] tmp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            tmp[i] = tmp[i-1] + times[i-1];
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += tmp[i];
        }
        System.out.println(sum);
    }
}