import java.util.*;
import java.io.*;
public class Main {
    static class period implements Comparable<period> {
        int sMonth, sDay, eMonth, eDay;
        public period(int sMonth, int sDay, int eMonth, int eDay) {
            this.sMonth = sMonth;
            this.sDay = sDay;
            this.eMonth = eMonth;
            this.eDay = eDay;
        }
        //피는날 기준 오름차순 정렬
        @Override
        public int compareTo(period o) {
            if (this.sMonth == o.sMonth) return this.sDay - o.sDay;
            return this.sMonth - o.sMonth;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            period period = (period) o;
            return sMonth == period.sMonth && sDay == period.sDay && eMonth == period.eMonth && eDay == period.eDay;
        }

        @Override
        public int hashCode() {
            return Objects.hash(sMonth, sDay, eMonth, eDay);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<period> list = new ArrayList<>();
        Set<period> set = new HashSet<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int sm = Integer.parseInt(st.nextToken());
            int sd = Integer.parseInt(st.nextToken());
            int em = Integer.parseInt(st.nextToken());
            int ed = Integer.parseInt(st.nextToken());
            list.add(new period(sm, sd, em, ed));
        }
        Collections.sort(list);

        int formerMonth = 3;
        int formerDay = 1;
        int result = 0;
        boolean end = false;
        while (true) {
            PriorityQueue<period> pq = new PriorityQueue<>((o1, o2) -> {
                if (o1.eMonth == o2.eMonth) return o2.eDay - o1.eDay;
                return o2.eMonth - o1.eMonth;
            });
            for (int i = 0; i < n; i++) {
                period now = list.get(i);
                if (now.sMonth < formerMonth || (now.sMonth==formerMonth && now.sDay <= formerDay)) {
                    if (!set.contains(now)) {
                        pq.add(now);
                        set.add(now);
                    }
                    if (i == n-1) end = true;
                } else {
                    break;
                }
            }
            if (pq.isEmpty()) {
                result = 0;
                break;
            }
            period selected = pq.poll();
            formerMonth = selected.eMonth;
            formerDay = selected.eDay;
            result++;
            if (selected.eMonth > 11) break;
            if (end) {
                result = 0;
                break;
            }
        }
        System.out.println(result);
    }
}