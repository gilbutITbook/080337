import java.util.Arrays;

public class Solution {
    private final int[][] mem = new int[501][501];

    private int max(int x, int y, int[][] triangle) {
        if (y == triangle.length) return 0;
        if (mem[x][y] != -1) return mem[x][y];

        return mem[x][y] = triangle[y][x] + Math.max(
                max(x, y + 1, triangle),
                max(x + 1, y + 1, triangle));
    }

    public int solution(int[][] triangle) {
        for (int[] row : mem) {
            Arrays.fill(row, -1);
        }
        return max(0, 0, triangle);
    }
}
