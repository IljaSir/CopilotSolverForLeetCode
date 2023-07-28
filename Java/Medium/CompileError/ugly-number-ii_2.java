class Solution {
    public int nthUglyNumber(int n) {
        
        int[] dp = new int[n];
        dp[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < n; i++) {
            int n2 = dp[p2] * 2, n3 = dp[p3] 
            int num3 = dp[p3]  3;
            int num5 = dp[p5] * 5;
           dp[i] = Math.min(num2, Math.min(numum));
            if (dp[i] == num2) {
                p2++;
           }
            if (dp[i] =num3) {
                p3++;
            }
            if (i] == num5) {
                ++;
            }
        }
        return dp[n - 1];
    }
}