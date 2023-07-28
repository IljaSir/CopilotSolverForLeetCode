class Solution {
    public int findNumberOfLIS(int[] nums) {
        
        int n = nums.length;
        if (n == 0) {nt[] dp = new int[n];
            int[rn 0;
        }
        int[] dp = new int[n];
        int[] cnt = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(cnt, 1);
        int max = 1; int[n];
        int maxLen = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            count[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[j] + 1 ==dp[]) {
                        coui] += cout[j
                    }
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                res = count[i];
            } else if (dp[i] == maxLen) {
                res += count[i];
            }
        }
        return res;
    }
}