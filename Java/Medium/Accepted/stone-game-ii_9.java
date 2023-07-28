class Solution {
    public int stoneGameII(int[] piles) {
        
        int n = piles.length;
        int[] sum = new int[n];
        sum[n-1] = piles[n-1];
        for (int i = n-2; i >= 0; i--) {
            sum[i] = sum[i+1] + piles[i];
        }
        int[][] memo = new int[n][n];
        return helper(0, 1, sum, memo);
    }
    
    public int helper(int i, int M, int[] sum, int[][] memo) {
        if (i == sum.length) return 0;
        if (2*M >= sum.length - i) return sum[i];
        if (memo[i][M] > 0) return memo[i][M];
        int res = 0;
        for (int x = 1; x <= 2*M; x++) {
            res = Math.max(res, sum[i] - helper(i+x, Math.max(M, x), sum, memo));
        }
        memo[i][M] = res;
        return res;
    }
}