class Solution {
public:
    int minSkips(vector<int>& dist, int speed, int hoursBefore) {
        
        int n = dist.size();
        vector<vector<int>> dp(n, vector<int>(n+1, INT_MAX));
        dp[0][0] = ceil((double)dist[0]/speed);
        for (int i = 1; i < n; ++i) {
            dp[i][0] = dp[i-1][0] + ceil((double)dist[i]/speed);
            for (int j = 1; j <= i; ++j) {
                dp[i][j] = min(dp[i-1][j], dp[i-1][j-1] + ceil((double)dist[i]/speed));
            }
        }
        for (int i = 0; i <= n; ++i) {
            if (dp[n-1][i] <= hoursBefore) return i;
        }
        return -1;
    }
};