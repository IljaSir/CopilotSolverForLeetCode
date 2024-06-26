class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        
        int n = nums.length;
        int res = 0;
        Map<Long, Integer>[] dp = new Map[n];
        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i] - nums[j];
                int cnt = dp[j].getOrDefault(diff, 0);
                res += cnt;
                dp[i].put(diff, dp[i].getOrDefault(diff, 0) + cnt + 1);
            }
        }
        return res;
    }
}