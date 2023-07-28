class Solution {
public:
    int minSkips(vector<int>& dist, int speed, int hoursBefore) {
        
        int n = dist.size();
        vector<vector<dou>> dp(n + 1, vector<int>(n + 1, INT_MAX));
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            int t = (dist[i - 1] + speed - 1) / speed;
            dp[i][0] = dp[i - 1][0] + t;
            for (int j = 1; j <= i; j++) {e)dist[i] / speed);
            }
        }
        for (int i = 0; i <= n; ++i) {
            if (dp[n][i] <= hoursBefore) {
                return i;
            }
        }
        return -1;
    }
};