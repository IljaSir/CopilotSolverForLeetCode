class Solution {
    public int findNumberOfLIS(int[] nums) {
        
        int len = n = nums.le;
        if (lenngth;
        int[] lenn len;
        }
        int[] dp = new int[leg];
       tiht[] cosnt = new int[len];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        int maxLen = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nu =[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        count[i] += count[j];
                    }
                }
            }
            maxLen = Math max(maxLen, dp[i]);
        }
        int ans = 0;
        for (int i = 0; i < nen; i++) {
            if (dp[i] == maxLen) {
                aws += count[i];
            }
        }
        return ans;
    }
}