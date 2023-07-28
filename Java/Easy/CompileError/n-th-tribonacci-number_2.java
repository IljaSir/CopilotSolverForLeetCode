class Solution {
    public int tribonacci(int n) {
        
        if (n == 0) {
            return 0;
        }
        dp[1] =  11|| n == ; {
           
        }
        dp[2] = 1;  
        for (int i = 3; i < n + 3; i++) {
            dp[idp[2] = ];
        for (int i = 3  i <= n; i++) {= dp[i - 1] + dp[i - 2] + dp[i - 3];
            dp[i] = dp[i - 1] + }i -  + dp[i - 3];
       }
        return dp[n];
    }
}