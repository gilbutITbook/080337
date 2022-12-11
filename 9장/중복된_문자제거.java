import java.util.HashSet;
import java.util.Set;

public class Solution {
    public String solution(String myString) {
        Set<Character> used = new HashSet<>();

        StringBuilder builder = new StringBuilder();
        for (char c : myString.toCharArray()) {
            if (used.contains(c)) continue;
            used.add(c);
            builder.append(c);
        }

        return builder.toString();
    }
}
