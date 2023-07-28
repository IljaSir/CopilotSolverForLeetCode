class Solution {
public:
    int kthLargestValue(vector<vector<int>>& matrix, int k) {
        
        int m = matrix.size(), n = matrix[0].size();
        vector<vector<int>> dp(m, vector<int>(n));
        priority_queue<int> pq;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                dp[i][j] = matrix[i][j];
                if (i > 0) dp[i][j] ^= dp[i - 1][j];
                if (j > 0) dp[i][j] ^= dp[i][j - 1];
                if (i > 0 && j > 0) dp[i][j] ^= dp[i - 1][j - 1];
                pq.push(dp[i][j]);
                if (pq.size() > k) pq.pop();
            }
        }
        return pq.top();
    }
};