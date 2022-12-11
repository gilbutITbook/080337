public class Solution {
    private boolean isPrime(long v) {
        if (v <= 1) return false;

        for (long i = 2; i * i <= v; i++) {
            if (v % i == 0) return false;
        }
        return true;
    }

    public int solution(int n, int k) {
        String[] tokens = Long.toString(n, k).split("0+");

        int count = 0;
        for (String token : tokens) {
            if (isPrime(Long.parseLong(token))) count++;
        }
        return count;
    }
}
