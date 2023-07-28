class Solution {
    public boolean matchReplacement(String s, String sub, char[][] mappings) {
        
        int n = s.length(), m = sub.length();
        int[][] map = new int[26][26];
        for (char[] mapping : mappings) {
            map[mapping[0] - 'a'][mapping[1] - 'a']++;
        }
        int[] dp = new int[m + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            int[] next = new int[m + 1];
            Arrays.fill(next, -1);
            for (int j = 0; j <= m; j++) {
                if (dp[j] != -1) {
                    if (j < m && s.charAt(i) == sub.charAt(j)) {
                        next[j + 1] = dp[j];
                    }
                    for (int k = 0; k < 26; k++) {
                        if (map[s.charAt(i) - 'a'][k] > 0) {
                            next[j] = Math.max(next[j], dp[j] + map[s.charAt(i) - 'a'][k]);
                        }
                    }
                }
            }
            dp = next;
        }
        return dp[m] >= m;
    }
}