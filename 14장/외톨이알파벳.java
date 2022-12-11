public class Solution {
    public String solution(String inputString) {
        inputString = "." + inputString + ".";

        StringBuilder builder = new StringBuilder();
        for (char c = 'a'; c <= 'z'; c++) {
            if (inputString.split(c + "+").length < 3) {
                continue;
            }
            builder.append(c);
        }

        if (builder.length() == 0) return "N";
        return builder.toString();
    }
}
