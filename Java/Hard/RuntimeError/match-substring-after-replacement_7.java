class Solution {
    public boolean matchReplacement(String s, String sub, char[][] mappings) {
        
        int n = s.length();
        int m = sub.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i - 1][j - 1] + (s.charAt(i - 1) == sub.charAt(j - 1) ? 1 : 0);
            }
        }
        Map<Character, Set<Character>> map = new HashMap<>();
        for (char[] mapping : mappings) {
            Set<Character> set = map.getOrDefault(mapping[0], new HashSet<>());
            set.add(mapping[1]);
            map.put(mapping[0], set);
        }
        boolean[] visited = new boolean[26];
        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            if (!map.containsKey(c)) {
                continue;
            }
            if (!dfs(c, map, visited)) {
                return false;
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (dp[i][j] == j) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char c, Map<Character, Set<Character>> map, boolean[] visited) {
        if (visited[c - 'a']) {
            return false;
        }
        visited[c - 'a'] = true;
        if (!map.containsKey(c)) {
            return true;
        }
        for (char next : map.get(c)) {
            if (!dfs(next, map, visited)) {
                return false;
            }
        }
        visited[c - 'a'] = false;
        return true;
    }
}