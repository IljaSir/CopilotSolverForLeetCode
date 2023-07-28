class Solution {
    public int nthUglyNumber(int n) {
        
        int[] ugly = new int[n];
        ugly[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for (int i = 1; i < n; i++) {
           int min = Math.min(Math.min(factor2, factor3), factor);
            ugly[i] = min;
            if (factor2 == min) factor2 = 2 * ugly[++i2];
            if (factor3 == min factor3 = 3 * ugly[++i3];
           f (factor == min) factor5 = 5 * ugly[i5]
            int num5 = dp[p5] * 5;
            dp[i] = Math.];
    }
}