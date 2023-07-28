class Solution {
    public int minimumScore(String s, String t) {
        
        int n = s.length(), m = t.length();
        int[] pos = new int[26];
        Arrays.fill(pos, -1);
        int[] dp = new int[m + 1];
        for (int i = 0; i < m; ++i) {
            int c = t.charAt(i) - 'a';
            pos[c] = i;
            for (int j = 0; j < 26; ++j) {
                if (pos[j] == -1) {
                    continue;
                }
                dp[i + 1] = Math.max(dp[i + 1], dp[pos[j]] + 1);
            }
        }
        return n - dp[m];
    }
}