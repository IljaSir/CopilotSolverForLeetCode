class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        
        Map<Integer, Set<Integer>> langMap = new HashMap<>();
        for (int i = 0; i < languages.length; i++) {
            for (int j = 0; j < languages[i].length; j++) {
                langMap.computeIfAbsent(i, k -> new HashSet<>()).add(languages[i][j]);
            }
        }
        Map<Integer, Set<Integer>> friendshipMap = new HashMap<>();
        for (int i = 0; i < friendships.length; i++) {
            int[] friendship = friendships[i];
            if (langMap.get(friendship[0] - 1).equals(langMap.get(friendship[1] - 1))) {
                continue;
            }
            friendshipMap.computeIfAbsent(friendship[0], k -> new HashSet<>()).add(friendship[1]);
            friendshipMap.computeIfAbsent(friendship[1], k -> new HashSet<>()).add(friendship[0]);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            Map<Integer, Integer> langCount = new HashMap<>();
            for (Map.Entry<Integer, Set<Integer>> entry : friendshipMap.entrySet()) {
                Set<Integer> langs = langMap.get(entry.getKey() - 1);
                if (langs.contains(i)) {
                    continue;
                }
                for (Integer friend : entry.getValue()) {
                    Set<Integer> friendLangs = langMap.get(friend - 1);
                    if (friendLangs.contains(i)) {
                        continue;
                    }
                    langCount.compute(friend, (k, v) -> v == null ? 1 : v + 1);
                }
            }
            min = Math.min(min, langCount.values().stream().mapToInt(v -> v).sum());
        }
        return min;
    }
}