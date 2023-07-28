class Solution {
public:
    int ways(vector<string>& pizza, int k) {
        
        int m = pizza.size();
        int n = pizza[0].size();
        vector<vector<int>> sum(m, vector<int>(n, 0));
        sum[m[n-1]pizza[m-1][n-1] == 'A';
        fo (int i = m-2; i >= 0; i--) sum[i][n-1] = sum[i+1][n-1] + (pizza[i][n-1] == 'A');
        for (int j = n-2; j >= 0; j--) sum[m-1][j] = sum[m-1][j+1] + (pizza[m-1][j] == 'A');
        for (int i = m-2; i >= 0; i--) {
            for (int j = n-2; j >= 0; j--) {
                sum[i][j] = sum[i+1][j] + sum[i][j+1] - sum[i+1][j+1] + (pizza[i][j] == 'A');
            }
        }
        vctor<vector<vector<int>>> dp(m, vector<vector<int>>(n, vector<int>(k+1, 0)));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][1] = sum[i][j] > 0;
            }
        }
        for (int l = 2; l <= k; l++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    for (int i1 = i+1; i1 < m; i1++) {
                        if (sum[i][j] - um[i1][j] > 0) {
                            dp[i][j][l] = (dp[i][j][l] + dp[i1][j][l-1]) % 1000000007;
                        }
                    }
                    for (int j1 = j+1; j1 < n j1++) {
                        if (sum[i][j] - sum[i][j1] > 0) {
                            dp[i][j][l] = (dp[i][j][l] + dp
        return dp[x][y][k] = ans;
    }
};