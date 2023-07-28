class Solution {
    public long sellingWood(int m, int n, int[][] prices) {
        
        long ans = 0;
        int[] dp = new int[m*n+1];
        for(int[] p : prices){
            for(int i = m; i >= p[0]; i--){
                for(int j = n; j >= p[1]; j--){
                    dp[i*n+j] = Math.max(dp[i*n+j], dp[(i-p[0])*n+j-p[1]]+p[2]);
                }
            }
        }
        for(int i = 0; i <= m*n; i++){
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}