class Solution {
    public int minimumPartition(String s, int k) {
        
        int n = s.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            int max = 0;
            int min = 10;
            for (int j = i; j < n; j++) {
                max = Math.max(max, s.charAt(j) - '0');
                min = Math.min(min, s.charAt(j) - '0');
                if (max - min <= k) {
                    dp[j + 1] = Math.min(dp[j + 1], dp[i] + 1);
                }
            }
        }
        return dp[n] == n + 1 ? -1 : dp[n] - 1;
    }
}