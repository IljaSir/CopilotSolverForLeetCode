class Solution {
    public int countMaxOrSubsets(int[] nums) {
        
        int n = nums.length;
        int[] dp = new int[1 << n];
        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    dp[i] = dp[i ^ (1 << j)] | nums[j];
                    break;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < (1 << n); i++) {
            max = Math.max(max, dp[i]);
        }
        int res = 0;
        for (int i = 0; i < (1 << n); i++) {
            if (dp[i] == max) {
                res++;
            }
        }
        return res;
    }
}