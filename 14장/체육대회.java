import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    private final Map<String, Integer> mem = new HashMap<>();

    private String toString(int student, boolean[] isChosen) {
        return student + Arrays.toString(isChosen);
    }

    private int max(int student, boolean[] isChosen, int[][] ability) {
        if (student == ability.length) return 0;
        String memKey = toString(student, isChosen);
        if (mem.containsKey(memKey)) return mem.get(memKey);

        int max = max(student + 1, isChosen, ability);

        for (int i = 0; i < ability[student].length; i++) {
            if (isChosen[i]) continue;
            isChosen[i] = true;
            int score = max(student + 1, isChosen, ability)
                    + ability[student][i];
            if (score > max) {
                max = score;
            }
            isChosen[i] = false;
        }

        mem.put(memKey, max);
        return max;
    }

    public int solution(int[][] ability) {
        return max(0, new boolean[ability.length], ability);
    }
}
