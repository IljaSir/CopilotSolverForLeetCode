class Solution {
    public boolean canDistribute(int[] nums, int[] quantity) {
        
        int n = nums.length;
        int m = quantity.length;
        int[] cnt = new int[101];
        for (int num : nums) {
            cnt[num]++;
        }
        Arrays.sort(quantity);
        int[] q = new int[m];
        int k = 0;
        for (int i = m - 1; i >= 0; i--) {
            if (k == 0 || quantity[i] != q[k - 1]) {
                q[k++] = quantity[i];
            }
        }
        int[] dp = new int[1 << k];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 0; i < 101; i++) {
            if (cnt[i] == 0) {
                continue;
            }
            int[] next = Arrays.copyOf(dp, 1 << k);
            for (int mask = 0; mask < (1 << k); mask++) {
                if (dp[mask] == -1) {
                    continue;
                }
                int sum = dp[mask];
                for (int j = 0; j < k; j++) {
                    if (((mask >> j) & 1) == 0) {
                        if (sum + q[j] <= cnt[i]) {
                            next[mask | (1 << j)] = Math.max(next[mask | (1 << j)], sum + q[j]);
                        } else {
                            break;
                        }
                    }
                }
            }
            dp = next;
        }
        return dp[(1 << k) - 1] != -1;
    }
}