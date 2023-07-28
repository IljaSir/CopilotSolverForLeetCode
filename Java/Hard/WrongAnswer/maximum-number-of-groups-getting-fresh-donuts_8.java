class Solution {
    public int maxHappyGroups(int batchSize, int[] groups) {
        
        int[] remainders = new int[batchSize];
        int res = 0;
        for (int g : groups) {
            if (g % batchSize == 0) {
                res++;
            } else {
                remainders[g % batchSize]++;
            }
        }
        int[] dp = new int[batchSize];
        for (int i = 1; i < batchSize; i++) {
            dp[i] = Integer.MIN_VALUE;
        }
        for (int i = 1; i < batchSize; i++) {
            if (remainders[i] == 0) {
                continue;
            }
            int[] next = new int[batchSize];
            for (int j = 0; j < batchSize; j++) {
                if (dp[j] == Integer.MIN_VALUE) {
                    continue;
                }
                int r = (j + i) % batchSize;
                next[r] = Math.max(next[r], dp[j] + (r == 0 ? 1 : 0));
                if (remainders[i] > 1) {
                    next[j] = Math.max(next[j], dp[j]);
                }
            }
            next[i] = Math.max(next[i], remainders[i]);
            dp = next;
        }
        return res + dp[0];
    }
}