import java.io.*;
import java.util.*;
public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //사람 수
        int m = Integer.parseInt(st.nextToken()); //파티 수
        parent = new int[n + 1];
        int[] parties = new int[m];
        for (int i = 1; i <= n; i++) parent[i] = i;

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken()); //진실을 아는 사람들의 수
        if (k == 0) {
            System.out.println(m);
            return;
        }
        int[] truth = new int[k]; //진실을 아는 사람들의 번호
        for (int i = 0; i < k; i++) {
            truth[i] = Integer.parseInt(st.nextToken());
            if (i > 0) union(truth[i-1], truth[i]);
        }
        Arrays.sort(truth);
        int root = truth[0]; //진실 아는 사람 root

        int count = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int[] tmp = new int[t];
            for (int j = 0; j < t; j++) {
                tmp[j] = Integer.parseInt(st.nextToken());
                if (j > 0) union(tmp[j-1], tmp[j]);
            }
            parties[i] = tmp[t-1];
        }
        for (int i = 1; i <= n; i++) {
            parent[i] = find(i);
        }
        root = parent[root];
//        System.out.println("root: "+root);
//        System.out.println("parties: "+ Arrays.toString(parties));
        for (int party : parties) {
            if (parent[party] != root) count++;
        }
//        System.out.println("parents: "+Arrays.toString(parent));
        System.out.println(count);

    }

    static boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) return false;
        if (x <= y) parent[y] = x;
        else parent[x] = y;
        return true;
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return find(parent[x]);
    }
}