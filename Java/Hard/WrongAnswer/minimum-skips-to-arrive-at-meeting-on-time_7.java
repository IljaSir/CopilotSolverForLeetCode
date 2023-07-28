class Solution {
    public int minSkips(int[] dist, int speed, int hoursBefore) {
        
        int n = dist.length;
        int[][] dp = new int[n+1][n+1];
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= n; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= n; j++){
                if(dp[i][j] == Integer.MAX_VALUE)
                    continue;
                int t = dp[i][j] + dist[i];
                int r = t % speed == 0 ? t / speed : t / speed + 1;
                dp[i+1][j] = Math.min(dp[i+1][j], r);
                if(j < n){
                    t = dp[i][j] + (dist[i] + speed - 1) / speed * speed;
                    r = t % speed == 0 ? t / speed : t / speed + 1;
                    dp[i+1][j+1] = Math.min(dp[i+1][j+1], r);
                }
            }
        }
        for(int i = 0; i <= n; i++){
            if(dp[n][i] <= hoursBefore * speed)
                return i;
        }
        return -1;
    }
}