import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean solution(String[] phoneBook) {
        Set<String> phoneNumbers = new HashSet<>();

        phoneBook = Arrays.stream(phoneBook)
                .sorted((p1, p2) -> {
                    return p1.length() - p2.length();
                })
                .toArray(String[]::new);

        for (String phone : phoneBook) {
            for (int end = 1; end < phone.length(); end++) {
                String prefix = phone.substring(0, end);

                if(phoneNumbers.contains(prefix)) return false;
            }

            phoneNumbers.add(phone);
        }

        return true;
    }
}