import java.util.Arrays;

public class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < answer.length; i++) {
            int[] command = commands[i];
            int from = command[0] - 1;  // 0-base
            int to = command[1];  // exclusive
            int k = command[2] - 1;  // 0-base

            int[] sub = Arrays.copyOfRange(array, from, to);
            Arrays.sort(sub);
            answer[i] = sub[k];
        }

        return answer;
    }
}
