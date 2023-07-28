class Solution {
public:
    int minimumWhiteTiles(string floor, int numCarpets, int carpetLen) {
        
        int n = floor.size();
        vector<int> c(n);
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            if (floor[i] == '1') {
                sum++;
            }
            c[i] = sum;
        }
        vector<vector<int>> dp(n, vector<int>(numCarpets + 1, INT_MAX));
        for (int i = carpetLen - 1; i < n; ++i) {
            dp[i][1] = c[i] - (i >= carpetLen ? c[i - carpetLen] : 0);
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 1; j <= numCarpets; ++j) {
                if (j > (i + 1) / carpetLen) {
                    continue;
                }
                if (i > 0) {
                    dp[i][j] = min(dp[i][j], dp[i - 1][j]);
                }
                if (i >= carpetLen && j >= 2) {
                    dp[i][j] = min(dp[i][j], dp[i - carpetLen][j - 1] + c[i] - c[i - carpetLen]);
                }
            }
        }
        return dp[n - 1][numCarpets];
    }
};