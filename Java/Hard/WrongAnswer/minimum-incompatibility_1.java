class Solution {
    public int minimumIncompatibility(int[] nums, int k) {
        
        int n = nums.length;
        int[] dp = new int[1 << n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int mask = 0; mask < (1 << n); mask++) {
            int[] cnt = new int[n + 1];
            int max = 0, min = n + 1, total = 0;
            for (int i = 0; i < n; i++) {
                if (((mask >> i) & 1) == 1) {
                    total++;
                    cnt[nums[i]]++;
                    max = Math.max(max, nums[i]);
                    min = Math.min(min, nums[i]);
                }
            }
            if (total % k != 0) {
                continue;
            }
            boolean flag = true;
            for (int i = 1; i <= n; i++) {
                if (cnt[i] > 1) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                continue;
            }
            int submask = mask;
            do {
                if (dp[submask] != -1 && dp[mask ^ submask] != -1) {
                    if (dp[mask] == -1) {
                        dp[mask] = dp[submask] + dp[mask ^ submask] + max - min;
                    } else {
                        dp[mask] = Math.min(dp[mask], dp[submask] + dp[mask ^ submask] + max - min);
                    }
                }
                submask = (submask - 1) & mask;
            } while (submask != mask);
        }
        return dp[(1 << n) - 1];
    }
}