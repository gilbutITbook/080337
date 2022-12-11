public class Solution {
    private int power(int n, int m) {
        if (m == 0) return 1;
        if (n == 1) return 1;
        if (n == 0) return 1;

        return n * power(n, m - 1);
    }
}
