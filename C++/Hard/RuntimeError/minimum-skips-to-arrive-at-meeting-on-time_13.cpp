class Solution {
public:
    int minSkips(vector<int>& dist, int speed, int hoursBefore) {
        
        int n = dist.size();
        vector<vector<int>> dp(n, vector<int>(n+1, INT_MAX));
        dp[0][0] = (dist[0] + speed - 1) / speed;
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i-1][0] + (dist[i] + speed - 1) / speed;
            for (int j = 1; j <= i; j++) {
                dp[i][j] = min(dp[i-1][j-1], dp[i-1][j] + (dist[i] + speed - 1) / speed);
                if (dist[i] % speed == 0) dp[i][j]--;
            }
        }
        for (int i = 0; i <= n; i++) {
            if (dp[n-1][i] <= hoursBefore) return i;
        }
        return -1;
    }
};