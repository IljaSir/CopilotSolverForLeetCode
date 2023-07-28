class Solution {
public:
    int findTheCity(int n, vector<vector<int>>& edges, int distanceThreshold) {
        
        vector<vector<int>> dp(n, vector<int>(n, 10001));
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }
        for (auto& e: edges) {
            dp[e[0]][e[1]] = e[2];
            dp[e[1]][e[0]] = e[2];
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dp[i][j] = min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }
        int minCnt = n;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (dp[i][j] <= distanceThreshold) {
                    cnt++;
                }
            }
            if (cnt <= minCnt) {
                minCnt = cnt;
                res = i;
            }
        }
        return res;
    }
};