class Solution {
    public int minSpaceWastedKResizing(int[] nums, int k) {
        
        int n = nums.length;
        int[][] dp = new int[n][k+1];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        int max = nums[0];
        for(int i = 1; i < n; i++) {
            max = Math.max(max, nums[i]);
            dp[i][0] = max * (i+1) - sum(nums, 0, i);
        }
        for(int i = 1; i < n; i++) {
            for(int j = 1; j <= k; j++) {
                int max1 = nums[i];
                for(int m = i-1; m >= 0; m--) {
                    max1 = Math.max(max1, nums[m]);
                    int spaceWasted = max1 * (i-m) - sum(nums, m, i);
                    if(dp[m][j-1] == Integer.MAX_VALUE) {
                        continue;
                    }
                    dp[i][j] = Math.min(dp[i][j], dp[m][j-1] + spaceWasted);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i <= k; i++) {
            ans = Math.min(ans, dp[n-1][i]);
        }
        return ans;
    }
    private int sum(int[] nums, int start, int end) {
        int sum = 0;
        for(int i = start; i <= end; i++) {
            sum += nums[i];
        }
        return sum;
    }
}