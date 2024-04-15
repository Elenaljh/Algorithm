import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(num);
        int i = 0, j = 0;
        int min = Integer.MAX_VALUE;
        while (i < n) {
            if (num[i] - num[j] < m) {
                i++;
            } else if (num[i]-num[j] == m) {
                min = m;
                break;
            } else { //m보다 큼
                min = Integer.min(min, num[i]-num[j]);
                j++;
            }
        }
        System.out.println(min);
    }
}