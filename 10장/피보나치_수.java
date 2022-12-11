import java.util.Arrays;

public class Solution {
    private final int[] mem = new int[100001];
    private int fibonacci(int n) {
        if (mem[n] != -1) return mem[n];
        if (n == 0 || n == 1) return n;

        return mem[n] = (fibonacci(n - 1) + fibonacci(n - 2)) % 1234567;
    }

    public int solution(int n) {
        Arrays.fill(mem, -1);
        for (int i = 0; i <= n; i++) {
            fibonacci(n);
        }
        return fibonacci(n);
    }
}
