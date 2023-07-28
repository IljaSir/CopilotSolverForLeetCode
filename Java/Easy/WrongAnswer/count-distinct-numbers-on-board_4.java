class Solution {
    public int distinctIntegers(int n) {
        
        int[] dp = new int[n+1];
        for(int i = 1; i <= n; i++){
            dp[i] = 1;
            for(int j = 2; j <= Math.sqrt(i); j++){
                if(i % j == 0){
                    dp[i] += dp[i/j];
                    if(i/j != j){
                        dp[i] += dp[j];
                    }
                }
            }
        }
        return dp[n];
    }
}