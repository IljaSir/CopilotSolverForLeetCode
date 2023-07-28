class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        
        int n = nums.length;
        int m = numsDivide.length;
        int[] cnt = new int[1000010];
        for (int num : numsDivide) {
            cnt[num]++;
        }
        int[] dp = new int[1000010];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;
        for (int i = 1; i <= 1000000; ++i) {
            if (cnt[i] == 0) {
                continue;
            }
            for (int j = 0; j < n; ++j) {
                if (nums[j] % i == 0) {
                    dp[i] = Math.min(dp[i], dp[i - 1] + j);
                }
            }
        }
        return dp[1000000] <= n ? dp[1000000] : -1;
    }
}