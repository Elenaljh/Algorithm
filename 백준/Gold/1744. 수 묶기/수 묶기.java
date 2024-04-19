import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> negatives = new ArrayList<>();
        List<Integer> positives = new ArrayList<>();
        int zeros = 0;
        int ones = 0;

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());
            if (a == 1) {
                ones++;
            } else if (a == 0) {
                zeros++;
            } else if (a < 0) {
                negatives.add(a);
            } else if (a > 0) {
                positives.add(a);
            }
        }
        negatives.sort(Comparator.naturalOrder());
        positives.sort(Comparator.reverseOrder());

        int result = 0;
        if (!negatives.isEmpty()) {
            if (negatives.size()%2==0) { //음수가 짝수개인 경우
                for (int i = 0; i < negatives.size()/2; i++) {
                    result += negatives.get(i*2) * negatives.get(i*2+1);
                }
            } else { //홀수개인 경우
                if (negatives.size()==1) {
                    if (zeros == 0) {
                        result += negatives.get(negatives.size()-1);
                    }
                } else {
                    for (int i = 0; i < negatives.size()/2; i++) {
                        result += negatives.get(i*2) * negatives.get(i*2+1);
                    }

                    if (zeros == 0) {
                        result += negatives.get(negatives.size()-1);
                    }
                }
            }

        }

        if (!positives.isEmpty()) {
            if (positives.size()%2==0) { //양수가 짝수개인 경우
                for (int i = 0; i < positives.size()/2; i++) {
                    result += positives.get(i*2) * positives.get(i*2+1);
                }
            } else {
                if (positives.size()==1) {
                    result += positives.get(positives.size()-1);
                } else {
                    for (int i = 0; i < positives.size()/2; i++) {
                        result += positives.get(i*2) * positives.get(i*2+1);
                    }
                    result += positives.get(positives.size()-1);
                }
            }
        }
        result += ones;

        System.out.println(result);

    }
}
/*
음수
- 홀수개일 경우 : 가장 큰 음수 하나만 남기고 나머지를 묶는다.

0이 있는 경우
- 남아있는 음수가 있는 경우 0과 묶는다.
- 그 외의 경우 묶지 않는다.

양수
- 홀수개일 경우 : 가장 작은 양수 하나만 남기고 나머지를 묶는다

수 묶기 규칙
- 절댓값 순서대로 나열한 후 큰 수들부터 차례로 묶는다.
 */