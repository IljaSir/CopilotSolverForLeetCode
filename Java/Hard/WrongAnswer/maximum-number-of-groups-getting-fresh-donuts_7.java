class Solution {
    public int maxHappyGroups(int batchSize, int[] groups) {
        
        int[] count = new int[batchSize];
        int res = 0;
        for (int g : groups) {
            int mod = g % batchSize;
            if (mod == 0) {
                res++;
            } else {
                count[mod]++;
            }
        }
        int[] dp = new int[batchSize];
        for (int i = 1; i < batchSize; i++) {
            for (int j = 0; j < batchSize; j++) {
                int next = (j + i) % batchSize;
                dp[next] = Math.max(dp[next], dp[j] + count[i]);
            }
        }
        return res + dp[0];
    }
}