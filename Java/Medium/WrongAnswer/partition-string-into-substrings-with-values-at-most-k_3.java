class Solution {
    public int minimumPartition(String s, int k) {
        
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            int max = 0;
            int min = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                max = Math.max(max, s.charAt(j) - '0');
                min = Math.min(min, s.charAt(j) - '0');
                if (max - min <= k) {
                    if (i == 0) {
                        dp[j] = 1;
                    } else if (dp[i - 1] != Integer.MAX_VALUE) {
                        dp[j] = Math.min(dp[j], dp[i - 1] + 1);
                    }
                }
            }
        }
        return dp[n - 1] == Integer.MAX_VALUE ? -1 : dp[n - 1];
    }
}