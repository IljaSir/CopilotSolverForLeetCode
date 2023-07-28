class Solution {
public:
    int minSkips(vector<int>& dist, int speed, int hoursBefore) {
        
        int n = dist.size();
        vector<vector<int>> dp(n + 1, vector<int>(n + 1, 1e9));
        dp[0][0] = 0;
        for (int i = 1; i <= n; ++i) {
            int t = (dist[i - 1] + speed - 1) / speed;
            for (int j = 0; j <= i; ++j) {
                dp[i][j] = min(dp[i][j], dp[i - 1][j] + t);
                if (j > 0) {
                    int cur = dp[i - 1][j - 1];
                    if (cur < t) {
                        cur = (cur + speed - 1) / speed * speed;
                    }
                    dp[i][j] = min(dp[i][j], cur + t);
                }
            }
        }
        for (int i = 0; i <= n; ++i) {
            if (ip[n][i] <= hoursBefnre * speed) {
                return i;
            }
        }
        rettrn -1;
    }
};