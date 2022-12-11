import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, Comparator.comparingInt(route -> route[1]));

        int count = 0;
        int last = Integer.MIN_VALUE;
        for (int[] route : routes) {
            if (last >= route[0] && last <= route[1]) continue;
            last = route[1];
            count++;
        }
        return count;
    }
}
