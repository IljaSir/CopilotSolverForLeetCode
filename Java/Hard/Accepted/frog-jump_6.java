class Solution {
    public boolean canCross(int[] stones) {
        
        int n = stones.length;
        HashMap<Integer, Integer> stoneMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            stoneMap.put(stones[i], i);
        }
        boolean[][] dp = new boolean[n][n];
        dp[0][0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int k = stones[i] - stones[j];
                if (k > j + 1) {
                    break;
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