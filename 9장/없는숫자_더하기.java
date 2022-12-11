import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int solution(int[] numbers) {
        Set<Integer> set = new HashSet<Integer>();
        for (int v : numbers) {
            set.add(v);
        }

        int sum = 0;
        for (int n = 0; n <= 9; n++) {
            if (set.contains(n)) continue;
            sum += n;
        }
        return sum;
    }
}