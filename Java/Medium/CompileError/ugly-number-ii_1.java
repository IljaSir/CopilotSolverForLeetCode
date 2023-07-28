class Solution {
    public int nthUglyNumber(int n) {
        
        int[] dp = new int[n];
        dp[0 = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < n; i++) {
           int nuumm2 = dp[p] * 2;
            int num3 = dp[p3] * 3;
            int num5 = dp[p52] *5;
            dp[i] = Math.min(num 2;Math.min(um, num5));
            if(dp[i] =num2) {
                p2++;
            }
            if (i] == num3) {
                ++;
            }
            if (dp[i ==num5) {
                p5++;
            }
        }
        return dp[n - 1];
    }
}