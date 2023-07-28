class Solution {
    public int tallestBillboard(int[] rods) {
        
        int sum = 0;
        for (int rod: rods) {
            sum += rod;
        }
        int[][] dp = new int[rods.length][sum+1];
        for (int i = 0; i < rods.length; i++) {
            for (int j = 0; j < sum+1; j++) {
                dp[i][j] = -1;
            }
        }
        return helper(rods, 0, 0, 0, dp);
    }
    private int helper(int[] rods, int i, int sum1, int sum2, int[][] dp) {
        if (i == rods.length) {
            if (sum1 == sum2) {
                return sum1;
            }
            return -1;
        }
        if (dp[i][sum1] != -1) {
            return dp[i][sum1];
        }
        int result = -1;
        // put in sum1
        int r1 = helper(rods, i+1, sum1+rods[i], sum2, dp);
        if (r1 != -1) {
            result = Math.max(result, r1);
        }
        // put in sum2
        int r2 = helper(rods, i+1, sum1, sum2+rods[i], dp);
        if (r2 != -1) {
            result = Math.max(result, r2);
        }
        // put in both
        int r3 = helper(rods, i+1, sum1+rods[i], sum2+rods[i], dp);
        if (r3 != -1) {
            result = Math.max(result, r3);
        }
        // put in none
        int r4 = helper(rods, i+1, sum1, sum2, dp);
        if (r4 != -1) {
            result = Math.max(result, r4);
        }
        dp[i][sum1] = result;
        return result;
    }
}