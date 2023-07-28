class Solution {
    public int nthUglyNumber(int n) {
        
        int[] dp = new int[n];
        dp[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < n; i++) {
            int num2 = dp[p2] * 2;
            int num3 = dp[p3] * 3; 5) i5++;
        }
        return ugly[n - 1];
    }
}