class Solution {
    public boolean canDistribute(int[] nums, int[] quantity) {
        
        int m = quantity.length;
        int n = nums.length;
        int[] cnt = new int[101];
        for (int i = 0; i < n; i++) {
            cnt[nums[i]]++;
        }
        int[] q = new int[m];
        int k = 0;
        for (int i = 0; i < 101; i++) {
            if (cnt[i] > 0) {
                q[k++] = cnt[i];
            }
        }
        int[] dp = new int[1 << m];
        dp[0] = 10000;
        for (int i = 0; i < k; i++) {
            for (int j = (1 << m) - 1; j >= 0; j--) {
                int s = dp[j];
                for (int l = 0; l < m; l++) {
                    if (((j >> l) & 1) == 0) {
                        if (s >= quantity[l]) {
                            dp[j | (1 << l)] = Math.max(dp[j | (1 << l)], s - quantity[l]);
                        }
                    }
                }
                if (s >= q[i]) {
                    dp[j] = Math.max(dp[j], s - q[i]);
                }
            }
        }
        return dp[(1 << m) - 1] != 0;
    }
}