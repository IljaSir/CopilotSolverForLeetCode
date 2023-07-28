class Solution {
    public int rearrangeCharacters(String s, String target) {
        
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : target.toCharArray()) {
            count[c - 'a']--;
        }
        for (int i : count) {
            if (i < 0) {
                return 0;
            }
        }
        int[] dp = new int[1 << target.length()];
        dp[0] = 1;
        for (int i = 0; i < (1 << target.length()); i++) {
            if (dp[i] == 0) {
                continue;
            }
            for (int j = 0; j < target.length(); j++) {
                if (((i >> j) & 1) == 1) {
                    continue;
                }
                int next = i | (1 << j);
                dp[next] = Math.max(dp[next], dp[i] + 1);
            }
        }
        return dp[(1 << target.length()) - 1];
    }
}