public class Solution {
    boolean solution(String s) {
        int ps = 0;
	int ys = 0;

        for (char c : s.toCharArray()) {
            switch (c) {
                case 'p', 'P' -> ps++;
                case 'y', 'Y' -> ys++;
            }
        }

        return ps == ys;
    }
}
