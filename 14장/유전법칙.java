import java.util.Arrays;

public class Solution {
    private String find(int n, int p) {
        if (n == 1) return "Rr";

        int slice = (int) Math.pow(4, n - 2);
        int group = p / slice;

        if (group == 0) return "RR";
        if (group == 3) return "rr";
        return find(n - 1, p % slice);
    }

    public String[] solution(int[][] queries) {
        return Arrays.stream(queries)
                .map(query -> find(query[0], query[1] - 1))
                .toArray(String[]::new);
    }
}
