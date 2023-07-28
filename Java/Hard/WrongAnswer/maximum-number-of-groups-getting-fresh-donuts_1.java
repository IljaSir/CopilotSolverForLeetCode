class Solution {
    public int maxHappyGroups(int batchSize, int[] groups) {
        
        int[] count = new int[batchSize];
        int ans = 0;
        for (int g : groups) {
            if (g % batchSize == 0) {
                ans++;
            } else {
                count[g % batchSize]++;
            }
        }
        for (int i = 1; i < batchSize; i++) {
            int j = batchSize - i;
            if (i < j) {
                ans += Math.min(count[i], count[j]);
            } else if (i == j) {
                ans += count[i] / 2;
            }
        }
        int[] dp = new int[batchSize];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i < batchSize; i++) {
            for (int j = 1; j <= count[i]; j++) {
                int[] next = dp.clone();
                for (int k = 0; k < batchSize; k++) {
                    if (dp[k] != -1) {
                        int r = (k + j * i) % batchSize;
                        next[r] = Math.max(next[r], dp[k] + (r == 0 ? 1 : 0));
                    }
                }
                dp = next;
            }
        }
        return ans + dp[0];
    }
}