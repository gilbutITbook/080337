import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<int[]> hanoi(int n, int from, int to) {
        if (n == 1) return List.of(new int[] {from, to});

        int empty = 6 - from - to;

        List<int[]> result = new ArrayList<>();
        result.addAll(hanoi(n - 1, from, empty));
        result.addAll(hanoi(1, from, to));
        result.addAll(hanoi(n - 1, empty, to));
        return result;
    }

    public int[][] solution(int n) {
        return hanoi(n, 1, 3).toArray(new int[0][]);
    }
}
