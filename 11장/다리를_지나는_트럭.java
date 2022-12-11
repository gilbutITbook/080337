import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int solution(int bridgeLength, int weight, int[] truckWeights) {
        int bridgeWeight = 0;
        Queue<Integer> bridge = new LinkedList<>();

        for (int i = 0; i < bridgeLength; i++) {
            bridge.add(0);
        }

        int time = 0;
        int truckIndex = 0;
        while (truckIndex < truckWeights.length) {
            bridgeWeight -= bridge.poll();

            int truckWeight = truckWeights[truckIndex];
            if (bridgeWeight + truckWeight <= weight) {
                bridge.add(truckWeight);
                bridgeWeight += truckWeight;
                truckIndex++;
            } else {
                bridge.add(0);
            }

            time++;
        }

        while (bridgeWeight > 0) {
            bridgeWeight -= bridge.poll();
            time++;
        }

        return time;
    }
}
