class Solution {
    public int distinctIntegers(int n) {
        
        int[] dp = new int[n+1];
        dp[1] = 1;
        for(int i=2; i<=n; i++){
            int j = 1;
            int count = 1;
            while(j*i <= n){
                if(dp[j*i] == 0){
                    dp[j*i] = 1;
                    count++;
                }
                j++;
            }
            dp[i] = count;
        }
        int sum = 0;
        for(int i=1; i<=n; i++){
            sum += dp[i];
        }
        return sum;
    }
}