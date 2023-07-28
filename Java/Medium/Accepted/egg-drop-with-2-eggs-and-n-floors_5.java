class Solution {
    public int twoEggDrop(int n) {
        
        int drops = 0;
        int eggs = 2;
        int floors = n;
        int[][] dp = new int[eggs + 1][floors + 1];
        for (int i = 0; i <= floors; i++) {
            dp[1][i] = i;
        }
        for (int i = 2; i <= eggs; i++) {
            for (int j = 1; j <= floors; j++) {
                dp[i][j] = 1 + dp[i - 1][j - 1] + dp[i][j - 1];
                if (dp[i][j] >= n) {
                    return j;
                }
            }
        }
        return drops;
    }
}