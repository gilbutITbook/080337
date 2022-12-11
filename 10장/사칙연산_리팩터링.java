import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    private interface IntComparator extends Comparator<Integer> {
    }

    private static final IntComparator[] COMP = {
            (a, b) -> Integer.compare(a, b),
            (a, b) -> Integer.compare(b, a),
    };

    private static final int[] INIT = {
            Integer.MIN_VALUE,
            Integer.MAX_VALUE,
    };

    private final int[][][] mem = new int[202][202][2];

    private int compute(int start, int end, int type, String[] arr) {
        if (mem[start][end][type] != Integer.MIN_VALUE) {
            return mem[start][end][type];
        }
        if (end - start == 1) return Integer.parseInt(arr[start]);

        int result = INIT[type];
        for (int i = start + 1; i < end; i += 2) {
            int l = compute(start, i, type, arr);
            int v;
            if (arr[i].equals("+")) {
                int r = compute(i + 1, end, type, arr);
                v = l + r;
            } else {
                int r = compute(i + 1, end, 1 - type, arr);
                v = l - r;
            }

            if (COMP[type].compare(v, result) > 0) result = v;
        }
        return mem[start][end][type] = result;
    }

    public int solution(String[] arr) {
        for (int[][] m : mem) {
            for (int[] row : m) {
                Arrays.fill(row, Integer.MIN_VALUE);
            }
        }

        return compute(0, arr.length, 0, arr);
    }
}
