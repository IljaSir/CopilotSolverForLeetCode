class Solution {
    public int longestIdealString(String s, int k) {
        
        int[] max = new int[26];
        int[] min = new int[26];
        Arrays.fill(max, -1);
        Arrays.fill(min, 100000);
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            max[c] = Math.max(max[c], i);
            min[c] = Math.min(min[c], i);
        }
        int[] maxGap = new int[26];
        for (int i = 0; i < 26; i++) {
            for (int j = i - k; j <= i + k; j++) {
                if (j < 0 || j >= 26) {
                    continue;
                }
                maxGap[i] = Math.max(maxGap[i], max[j] - min[i]);
            }
        }
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 0; i < s.length(); i++) {
            if (dp[i] == -1) {
                continue;
            }
            for (int j = 0; j < 26; j++) {
                if (maxGap[j] == 0) {
                    continue;
                }
                int next = i + maxGap[j];
                if (next <= s.length()) {
                    dp[next] = Math.max(dp[next], dp[i] + 1);
                }
            }
        }
        return dp[s.length()];
    }
}