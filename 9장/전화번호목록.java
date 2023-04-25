import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean solution(String[] phoneBook) {
        Set<String> prefixes = new HashSet<>();

        for (String phone : phoneBook) {
            for (int end = 1; end < phone.length(); end++) {
                prefixes.add(phone.substring(0, end));
            }
        }

        for (String phone : phoneBook) {
            if (prefixes.contains(phone)) {
                return false;
            }
        }

        return true;
    }
}
