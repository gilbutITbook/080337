import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> reports = new HashMap<>();
        for (String id : id_list) {
            reports.put(id, new HashSet<>());
        }

        Map<String, Integer> reported = new HashMap<>();

        for (String r : report) {
            String[] tokens = r.split(" ");
            String reporter = tokens[0];
            String target = tokens[1];

            Set<String> set = reports.get(reporter);
            if (set.contains(target)) continue;

            set.add(target);
            reported.putIfAbsent(target, 0);
            reported.put(target, reported.get(target) + 1);
        }

        Set<String> banned = reported.keySet().stream()
                .filter(id -> reported.get(id) >= k).collect(Collectors.toSet());

        return Arrays.stream(id_list)
                .mapToInt(id -> (int) reports.get(id).stream().filter(banned::contains).count())
                .toArray();
    }
}
