class Solution {
    public long kMirror(int k, int n) {
        
        long res = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i=1; i<n; i++){
            dp[i] = dp[i-1]*k;
        }
        for(int i=0; i<n; i++){
            res += dp[i];
        }
        return res;
    }
}