class Solution {
    public int findNumberOfLIS(int[] nums) {
        
        int n = nums.length;
        int dp[] = new int[n];
        int count[] = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        int max = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        count[i] += count[j];
                    }
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                res = count[i];
            } else if (dp[i] == max) {
                res += count[i];
            }
        }
        return res;
    }
}