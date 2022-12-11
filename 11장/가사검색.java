import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    private static class Node {
        private final Map<Integer, Integer> terminals = new HashMap<>();
        private final Map<Character, Node> children = new HashMap<>();

        public void add(String word, int offset) {
            int length = word.length() - offset;
            terminals.put(length, terminals.getOrDefault(length, 0) + 1);

            if (length > 0) {
                char c = word.charAt(offset);
                Node child = children.getOrDefault(c, new Node());
                child.add(word, offset + 1);
                children.put(c, child);
            }
        }

        public int count(String query, int offset) {
            if (query.charAt(offset) == '?') {
                return terminals.getOrDefault(query.length() - offset, 0);
            }

            char c = query.charAt(offset);
            if (!children.containsKey(c)) return 0;
            return children.get(c).count(query, offset + 1);
        }
    }

    private int count(String query, Node trie, Node reversedTrie) {
        if (query.startsWith("?")) {
            return reversedTrie.count(
                    new StringBuilder(query).reverse().toString(), 0);
        }

        return trie.count(query, 0);
    }

    public int[] solution(String[] words, String[] queries) {
        Node trie = new Node();
        Node reversedTrie = new Node();
        for (String word : words) {
            trie.add(word, 0);
            reversedTrie.add(
                    new StringBuilder(word).reverse().toString(), 0);
        }

        return Arrays.stream(queries)
                .mapToInt(query -> count(query, trie, reversedTrie))
                .toArray();
    }
}
