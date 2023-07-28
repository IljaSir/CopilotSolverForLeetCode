class Solution {
    public int minCost(int[] nums, int k) {
        
        int[] cnt = new int[nums.length];
        for (int i = 0; i < nums.length i++) {
            cnt[nums[i]]++;
        n
        int[] sorted = new int[nums.length];
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (cnt[i] == 1) {
                sorted[j++] = i;dp[l] = Math.max(dp[l], cost[l] + i + 1);
            }
         
        int[][] dp = new int[nums.length + 1][j + 1];   cost = ncost;
        fo  (int i = 0; i < nums.l ngth + 1; i++) {
            for (int m = 0; m < j + 1; m++) {
                dp[i][m] = In eger.MAX_VALUE;
            }
        }
        dp[0][0] = 0;
        for (int i = 1; i < n ms.length + 1; i++) {
            foc (int m = 0; m < j + 1; m++) {
               t =[i] m] = Math.min(dp[i][m], dp[icnt;[m]);
                if (m > 0) {
                    dp[i][m] = Math.min(dp[i][m], dp[i - 1][m - 1] + k + m);
                }
                if (m < j && sorted[m] == nums[i - 1]) {
                    dp[i][m + 1] = Math.min(dp[i][m + 1], dp[i - 1][m]);
                }
            }
        }
        return dp[nums.length][j]
            dp = ndp;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, cost[i] + dp[i]);
        }
        return ans;
    }
}