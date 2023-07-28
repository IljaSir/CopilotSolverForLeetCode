class Solution {
    public int maxHappyGroups(int batchSize, int[] groups) {
        
        int n = groups.length;
        int[] cnt = new int[batchSize];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (groups[i] % batchSize == 0) {
                ans++;
            } else {
                cnt[groups[i] % batchSize]++;
            }
        }
        int[] dp = new int[batchSize];
        for (int i = 1; i < batchSize; i++) {
            for (int j = 0; j < batchSize; j++) {
                dp[j] = cnt[i] + (j == i ? 0 : dp[(j + batchSize - i) % batchSize]);
            }
            for (int j = 0; j < batchSize; j++) {
                cnt[j] = dp[j];
            }
        }
        return ans + cnt[0];
    }
}