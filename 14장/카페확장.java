public class Solution {
    private static class Order {
        public final int time;
        public final int duration;

        public Order(int time, int duration) {
            this.time = time;
            this.duration = duration;
        }
    }

    public int solution(int[] menu, int[] order, int k) {
        Order[] orders = new Order[order.length];
        for (int i = 0; i < order.length; i++) {
            orders[i] = new Order(k * i, menu[order[i]]);
        }

        int max = 0;

        int time = 0;
        int end = 0;
        for (int start = 0; start < orders.length; start++) {
            Order o = orders[start];
            if (time < o.time) {
                time = o.time;
            }

            time += o.duration;
            while (end < orders.length && orders[end].time < time) {
                end++;
            }
            int count = end - start;
            if (count > max) {
                max = count;
            }
        }
        return max;
    }
}
