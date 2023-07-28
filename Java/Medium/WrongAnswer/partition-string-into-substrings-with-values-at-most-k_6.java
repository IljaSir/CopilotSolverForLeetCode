class Solution {
    public int minimumPartition(String s, int k) {
        
        int[] dp = new int[s.length()];
        int[] max = new int[s.length()];
        max[0] = s.charAt(0) - '0';
        for (int i = 1; i < s.length(); i++) {
            max[i] = Math.max(max[i - 1], s.charAt(i) - '0');
        }
        for (int i = 0; i < s.length(); i++) {
            if (max[i] <= k) {
                dp[i] = 1;
                continue;
            }
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (max[j] <= k && dp[j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[s.length() - 1] == Integer.MAX_VALUE ? -1 : dp[s.length() - 1];
    }
}