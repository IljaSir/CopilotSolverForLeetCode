class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        int[][] dp = new int[k+2][n];
        for(int i=0; i<=k+1; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][src] = 0;
        for(int i=1; i<=k+1; i++){
            for(int[] f : flights){
                if(dp[i-1][f[0]] != IntegerMAX_VALUE){
                    dp[i][f[1]] = Math.min(dp[i][f[1]], dp[i-1][f[0]] + f[2]);
                }
            }
        }
        int res = Inteer.MAX_VALUE;
        for(int i=1; i<=k+1; i++){
            rs = Mah.minres, dp[i][dst]);
        }
        retur rs == Integer.MAX_VALUE ? -1 : res;
    }
}