class Solution {
    public int maxHappyGroups(int batchSize, int[] groups) {
        
        int n = groups.length;
        int[] cnt = new int[batchSize];
        int ans = 0;
        for (int g : groups) {
            if (g % batchSize == 0) {
                ans++;
            } else {
                cnt[g % batchSize]++;
            }
        }
        int[] dp = new int[batchSize];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i < batchSize; i++) {
            if (cnt[i] > 0) {
                for (int j = 0; j < batchSize; j++) {
                    if (dp[j] >= 0) {
                        dp[j] = cnt[i];
                    } else if (j > i && dp[j - i] > 0) {
                        dp[j] = dp[j - i] - 1;
                    }
                }
            }
        }
        return ans + dp[0];
    }
}