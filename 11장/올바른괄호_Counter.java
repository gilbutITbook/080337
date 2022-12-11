import java.util.Stack;

public class Solution {
    private void findPair(char[] str) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < str.length; i++) {
            switch (str[i]) {
                case '(' -> stack.push(i);
                case ')' -> {
                    if (stack.isEmpty()) return;

                    // 짝이 되는 괄호의 인덱스 출력
                    System.out.println(stack.pop() + ", " + i);
                }
            }
        }
    }

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
