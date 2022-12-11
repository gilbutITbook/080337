import java.util.Arrays;

public class Solution {
    private int scoreDiff(int[] apeach, int[] ryan) {
        int diff = 0;
        for (int i = 0; i < apeach.length; i++) {
            if (apeach[i] == 0 && ryan[i] == 0) continue;

            if (apeach[i] >= ryan[i]) {
                diff -= 10 - i;
            } else {
                diff += 10 - i;
            }
        }
        return diff;
    }

    private boolean isPrior(int[] base, int[] comp) {
        for (int i = 10; i >= 0; i--) {
            if (comp[i] == base[i]) continue;
            return comp[i] > base[i];
        }
        return false;
    }

    private int[] ryan(int index, int[] hits, int n, int[] apeach) {
        if (index == hits.length) {
            if (n > 0) return null;
            if (scoreDiff(apeach, hits) <= 0) return null;
            return Arrays.copyOf(hits, hits.length);
        }

        int maxDiff = 0;
        int[] result = null;

        for (int hit = 0; hit <= n; hit++) {
            hits[index] = hit;
            int[] ryan = ryan(index + 1, hits, n - hit, apeach);
            if (ryan == null) continue;

            int diff = scoreDiff(apeach, ryan);
            if (diff > maxDiff ||
                    (diff == maxDiff && isPrior(result, ryan))) {
                maxDiff = diff;
                result = ryan;
            }
        }

        return result;
    }

    public int[] solution(int n, int[] info) {
        int[] ryan = ryan(0, new int[11], n, info);
        if (ryan == null) {
            return new int[] { -1 };
        }
        return ryan;
    }
}
