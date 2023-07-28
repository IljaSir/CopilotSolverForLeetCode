class Solution {
    public int maxHappyGroups(int batchSize, int[] groups) {
        
        int n = groups.length;
        int[] cnt = new int[batchSize];
        for (int i = 0; i < n; i++) {
            cnt[groups[i] % batchSize]++;
        }
        int res = 0;
        res += cnt[0];
        cnt[0] = 0;
        for (int i = 1; i < batchSize; i++) {
            int j = batchSize - i;
            int min = Math.min(cnt[i], cnt[j]);
            res += min;
            cnt[i] -= min;
            cnt[j] -= min;
        }
        int[] dp = new int[batchSize];
        dp[0] = 1;
        for (int i = 1; i < batchSize; i++) {
            if (cnt[i] > 0) {
                int[] next = new int[batchSize];
                for (int j = 0; j < batchSize; j++) {
                    if (dp[j] > 0) {
                        for (int k = 1; k <= cnt[i]; k++) {
                            next[(j + i * k) % batchSize] = Math.max(next[(j + i * k) % batchSize], dp[j] + k);
                        }
                    }
                }
                dp = next;
            }
        }
        return res + dp[0] - 1;
    }
}