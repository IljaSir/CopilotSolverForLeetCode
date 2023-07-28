class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        int[][] dp = new int[n][k+2];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for(int i=0; i<=k+1; i++){
            dp[src][i] = 0;
        }
        for(int i=1; i<=k+1; i++){
            for(int[] flight : flights){
                int from = flight[0], to = flight[1], cost = flight[2];
                if(dp[from][i-1] != Integer.MAX_VALUE){
                    dp[to][i] = Math.min(dp[to][i], dp[from][i-1] + cost);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i=1; i<=k+1; i++){
            ans = Math.min(ans, dp[dst][i]);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}