class Solution {
    public int findNumberOfLIS(int[] nums) {
        
        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];
        itmx = 0;
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            count[i] = 1;
            for(int j = 0; j < i; j++) {
                if(ums[j] < nums[i]) {
                    if(dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if(dp[j] + 1 == dp[i]) {
                        count[i] += count[j];
                    }
                }
            }
            if(dp[i] > max) {
                max = dp[i];
                res = count[i];
            } else if(dp[i] == max) {
                res += count[i];
            }
        }
        return re
    }
}