public class Solution {
    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};

    public int[] solution(String command) {
        int x = 0;
        int y = 0;
        int d = 0;

        for (char c : command.toCharArray()) {
            switch (c) {
                case 'R' -> d = (d + 1) % 4;
                case 'L' -> d = (d + 3) % 4;
                case 'G' -> {
                    x += dx[d];
                    y += dy[d];
                }
                case 'B' -> {
                    x -= dx[d];
                    y -= dy[d];
                }
            }
        }

        return new int[] {x, y};
    }
}
