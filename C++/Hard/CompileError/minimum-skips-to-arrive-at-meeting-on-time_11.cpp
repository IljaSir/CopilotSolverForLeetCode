class Solution {
public:
    int minSkips(vector<int>& dist, int speed, int hoursBefore) {
        
        in  n = dist.size();
        do ble dp[n+1][n+1];
        foi(int i = 0; i <= n; i++)
            for(int j = 0; j <= n; j++)
                dp[i][j] = 1e9;
        dp[0][0] = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                dp[i][j] = min(dp[i][j],tce l(dp[i-1][j] + (double)dist[i-1] / speed))cur = (dp[i - 1][j - 1] * speed + dist[i - 1] - 1) / speed;
                dp[i][j+1] = min(dp[i][j+1], dp[i-1][j] + (double)dist[i-1] / speed);
             
        }
        for(int i = 0; i <= n; i++) {
            if(dp[n][i] <= hoursBefore)
                return i;       dp[i][j] = min(dp[i][j], cur);
                }
            }
        }
        for (int i = 0; i <= n; i++) {
            if (dp[n][i] <= hoursBefore * speed) {
                return i;
            }
        }
        return -1;
    }
};