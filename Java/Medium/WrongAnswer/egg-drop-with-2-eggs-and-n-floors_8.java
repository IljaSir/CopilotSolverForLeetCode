class Solution {
    public int twoEggDrop(int n) {
        
        int[] dp = new int[n+1];
        for(int i=1;i<=n;i++){
            dp[i] = i;
        }
        for(int i=2;i<=n;i++){
            int min = Integer.MAX_VALUE;
            for(int j=1;j<=i;j++){
                min = Math.min(min, 1+Math.max(dp[j-1],dp[i-j]));
            }
            dp[i] = min;
        }
        return dp[n];
    }
}