class Solution {
public:
    int kthLargestValue(vector<vector<int>>& matrix, int k) {
        
        int m = matrix.size();
        int n = matrix[0].size();
        vector<vector<int>> dp(m, vector<int>(n));
        dp[0][0] = matrix[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i-1][0] ^ matrix[i][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j-1] ^ matrix[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] ^ dp[i][j-1] ^ dp[i-1][j-1] ^ matrix[i][j];
            }
        }
        vector<int> v;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                v.push_back(dp[i][j]);
            }
        }
        sort(v.begin(), v.end(), greater<int>());
        return v[k-1];
    }
};