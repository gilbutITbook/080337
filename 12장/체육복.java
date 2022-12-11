import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);

        Set<Integer> owns = Arrays.stream(lost)
                .boxed()
                .collect(Collectors.toSet());
        owns.retainAll(Arrays.stream(reserve)
                .boxed()
                .collect(Collectors.toSet()));

        Queue<Integer> q = new LinkedList<>();
        for (int l : lost) q.add(l);

        int get = 0;
        for (int r : reserve) {
            if (owns.contains(r)) {
                continue;
            }

            while (!q.isEmpty() &&
                    (q.peek() < r - 1 || owns.contains(q.peek()))) {
                q.poll();
            }
            if (q.isEmpty()) break;

            if (q.peek() <= r + 1) {
                q.poll();
                get++;
            }
        }

        return n - lost.length + owns.size() + get;
    }
}
