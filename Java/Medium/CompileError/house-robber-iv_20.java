class Solution {
    public int minCapability(int[] nums, int k) {
        
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = nums[i];
        }
        int[] min = new int[n];
        for (int i = 0; i < n; i++) {
            min[i] = nums[i];
        }
        for (int i = 1; i < k; i++) {
            int[] nextDp = new int[n];
            int[] nextMin = new int[n];
            for (int j = 0; j < n; j++) {
                int max = 0;
                for (int k = j + 1; k < n; k++) {
                    max = Math.max(max, dp[k]);
                }
                nextDp[j] = max + nums[j];
                nextMin[j] = Math.min(min[j], nextDp[j]);
            }
            dp = nextDp;
            min = nextMin;
        }
        int result = dp[0];
        for (int i = 1; i < n; i++) {
            result = Math.min(result, dp[i]);
        }
        return result;
    }
}