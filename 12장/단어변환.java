import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    private static class State {
        public final String word;
        public final int step;

        private State(String word, int step) {
            this.word = word;
            this.step = step;
        }
    }

    private boolean isConvertable(String src, String dst) {
        char[] srcArr = src.toCharArray();
        char[] dstArr = dst.toCharArray();

        int diff = 0;
        for (int i = 0; i < srcArr.length; i++) {
            if (srcArr[i] != dstArr[i]) diff++;
        }
        return diff == 1;
    }

    public int solution(String begin, String target, String[] words) {
        boolean[] isVisited = new boolean[words.length];

        Queue<State> queue = new LinkedList<>();
        queue.add(new State(begin, 0));

        while (!queue.isEmpty()) {
            State state = queue.poll();

            if (state.word.equals(target)) {
                return state.step;
            }

            for (int i = 0; i < words.length; i++) {
                String next = words[i];

                if (!isConvertable(state.word, next)) {
                    continue;
                }

                if (isVisited[i]) {
                    continue;
                }

                isVisited[i] = true;
                queue.add(new State(next, state.step + 1));
            }
        }

        return 0;
    }
}
