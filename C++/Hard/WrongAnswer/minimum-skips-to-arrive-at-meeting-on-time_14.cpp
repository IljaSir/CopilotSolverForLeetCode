class Solution {
public:
    int minSkips(vector<int>& dist, int speed, int hoursBefore) {
        
        int n = dist.size();
        double dp[n+1][n+1];
        for(int i = 0; i <= n; i++)
            for(int j = 0; j <= n; j++)
                dp[i][j] = 1e9;
        dp[0][0] = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                dp[i][j] = min(dp[i][j], ceil(dp[i-1][j] + (double)dist[i-1] / speed));
                dp[i][j+1] = min(dp[i][j+1], dp[i-1][j] + (double)dist[i-1] / speed);
            }
        }
        for(int i = 0; i <= n; i++) {
            if(dp[n][i] <= hoursBefore)
                return i;
        }
        return -1;
    }
};