class Solution {
    public int minimumNumbers(int num, int k) {
        
        int[] dp = new int[num + 1];
        Arrays.fill(dp, num + 1);
        dp[0] = 0;
        for (int i = 0; i <= num; i++) {
            for (int j = 0; j <= 9; j++) {
                if (i + j > num) {
                    continue;
                }
                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
            }
        }
        return dp[num] == num + 1 ? -1 : dp[num];
    }
}