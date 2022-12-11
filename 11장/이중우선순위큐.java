import java.util.PriorityQueue;

public class Solution {
    private static class DoublyPriorityQueue {
        private int size = 0;
        private final PriorityQueue<Integer> minPq
                = new PriorityQueue<>();
        private final PriorityQueue<Integer> maxPq
                = new PriorityQueue<>((a, b) -> b - a);

        public void add(int value) {
            minPq.add(value);
            maxPq.add(value);
            size++;
        }

        public void removeMax() {
            if (size == 0) return;
            maxPq.poll();
            if (--size == 0) {
                maxPq.clear();
                minPq.clear();
            }
        }

        public void removeMin() {
            if (size == 0) return;
            minPq.poll();
            if (--size == 0) {
                maxPq.clear();
                minPq.clear();
            }
        }

        public int max() {
            if (size == 0) return 0;
            return maxPq.peek();
        }

        public int min() {
            if (size == 0) return 0;
            return minPq.peek();
        }
    }

    public int[] solution(String[] operations) {
        DoublyPriorityQueue dpq = new DoublyPriorityQueue();
        for (String operation : operations) {
            String[] tokens = operation.split(" ");
            String command = tokens[0];
            String value = tokens[1];
            switch (command) {
                case "I" -> dpq.add(Integer.parseInt(value));
                case "D" -> {
                    if (value.equals("1")) {
                        dpq.removeMax();
                    } else {
                        dpq.removeMin();
                    }
                }
            }
        }
        return new int[]{dpq.max(), dpq.min()};
    }
}
