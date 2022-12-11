public class Solution {
    public int solution(int[][] board, int[][] skills) {
        int[][] changes =
                new int[board.length + 1][board[0].length + 1];

        for (int[] skill : skills) {
            int type = skill[0];
            int r1 = skill[1];
            int c1 = skill[2];
            int r2 = skill[3] + 1;
            int c2 = skill[4] + 1;
            int degree = skill[5];
            if (type == 1) degree = -degree;

            changes[r1][c1] += degree;
            changes[r2][c1] -= degree;
            changes[r1][c2] -= degree;
            changes[r2][c2] += degree;
        }

        for (int y = 0; y < changes.length; y++) {
            for (int x = 0; x < changes[y].length; x++) {
                int left = x > 0 ? changes[y][x - 1] : 0;
                int up = y > 0 ? changes[y - 1][x] : 0;
                int diag = x > 0 && y > 0 ? changes[y - 1][x - 1] : 0;

                changes[y][x] += left + up - diag;
            }
        }

        int safe = 0;
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                if (board[y][x] + changes[y][x] > 0) safe++;
            }
        }
        return safe;
    }
}
