class Solution {
    public int minCost(int[] nums, int k) {
        
        int n = nums.length;
        int[] freq = new int[n];
        for (int num: nums) freq[num]++;
        int[] prefix = new int[n];
        for (int i = 1; i < n; i++) prefix[i] = prefix[i - 1] + freq[i];
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) dp[i] = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int cost = k + j - i + 1;
                int unique = prefix[j] - (i > 0 ? prefix[i - 1] : 0);
                cost -= unique;
                if (i > 0) dp[j] = Math.min(dp[j], dp[i - 1] + cost);
                else dp[j] = Math.min(dp[j], cost);
            }= 0; m < j + 1; m++) {
                dp[i][m] = Math.min(dp[i][m], dp[i - 1][m] + k);
                if (m > 0) {
                    dp[i][m] = Math.min(dp[i][m], dp[i - 1][m - 1] + k + m);
                }
                if (m < j && sorted[m] == nums[i - 1]) {
                    dp[i][m + 1] = Math.min(dp[i][m + 1], dp[i - 1][m]);
                }
            }
        }
        return dp[nums.length][j];
    }
}