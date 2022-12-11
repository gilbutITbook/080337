public class Solution {
    private static class Coord {
        public final int x;
        public final int y;

        private Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static class Result {
        public final boolean win;
        public final int turns;

        private Result(boolean win, int turns) {
            this.win = win;
            this.turns = turns;
        }
    }

    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {-1, 1, 0, 0};

    private Result game(Coord player, Coord opponent,
                        int[][] board) {
        if (board[player.y][player.x] == 0) {
            return new Result(false, 0);
        }

        boolean win = false;
        int winTurns = Integer.MAX_VALUE;
        int loseTurns = Integer.MIN_VALUE;

        board[player.y][player.x] = 0;
        for (int d = 0; d < 4; d++) {
            int nx = player.x + dx[d];
            int ny = player.y + dy[d];

            if (ny < 0 || ny >= board.length ||
                    nx < 0 || nx >= board[ny].length) {
                continue;
            }
            if (board[ny][nx] == 0) {
                continue;
            }
            Result result = game(opponent, new Coord(nx, ny), board);
            if (!result.win) {
                win = true;
                winTurns = Math.min(winTurns, result.turns);
            } else if (!win) {
                loseTurns = Math.max(loseTurns, result.turns);
            }
        }
        board[player.y][player.x] = 1;

        if (win) {
            return new Result(true, winTurns + 1);
        }

        if (loseTurns == Integer.MIN_VALUE) {
            return new Result(false, 0);
        }

        return new Result(false, loseTurns + 1);
    }

    public int solution(int[][] board, int[] aloc, int[] bloc) {
        return game(new Coord(aloc[1], aloc[0]),
                new Coord(bloc[1], bloc[0]), board).turns;
    }
}
