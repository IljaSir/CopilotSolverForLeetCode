class Solution {
    public boolean canCross(int[] stones) {
        
        int n = stones.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(stones[i], i);
        }
        boolean[][] dp = new boolean[n][n];
        dp[0][0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int k = stones[i] - stones[j];
                if (k > j + 1) {
                    continue;
                }
                dp[i][k] = dp[j][k] || dp[j][k - 1] || dp[j][k + 1];
                if (i == n - 1 && dp[i][k]) {
                    return true;
                }
            }
        }
        return false;
    }
}