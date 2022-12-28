import java.util.Stack;

public class Solution {
    public boolean solution(String s) {
        int counter = 0;

        for (char c : s.toCharArray()) {
            switch (c) {
                case '(' -> counter++;
                case ')' -> {
                    if (counter-- == 0) return false;
                }
            }
        }

        return counter == 0;
    }
}
