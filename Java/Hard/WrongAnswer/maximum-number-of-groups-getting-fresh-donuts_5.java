class Solution {
    public int maxHappyGroups(int batchSize, int[] groups) {
        
        int[] count = new int[batchSize];
        int res = 0;
        for (int g : groups) {
            count[g % batchSize]++;
        }
        res += count[0];
        count[0] = 0;
        for (int i = 1; i < batchSize; i++) {
            int j = (batchSize - i) % batchSize;
            if (i < j) {
                continue;
            }
            int min = Math.min(count[i], count[j]);
            res += min;
            count[i] -= min;
            count[j] -= min;
        }
        int[] dp = new int[batchSize];
        dp[0] = 1;
        for (int i = 1; i < batchSize; i++) {
            if (count[i] > 0) {
                int[] next = new int[batchSize];
                for (int j = 0; j < batchSize; j++) {
                    if (dp[j] > 0) {
                        next[(j + i) % batchSize] = dp[j];
                    }
                }
                for (int j = 1; j < batchSize; j++) {
                    if (next[j] > 0) {
                        next[j] += count[i] - 1;
                    }
                }
                dp = next;
            }
        }
        for (int i = 1; i < batchSize; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}