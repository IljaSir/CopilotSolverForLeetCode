class Solution {
public:
    int kthLargestValue(vector<vector<int>>& matrix, int k) {
        
        int m = matrix.size();
        int n = matrix[0].size();
        vector<vector<int>> dp(m+1, vector<int>(n+1, 0));
        priority_queue<int, vector<int>, greater<int>> q;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                dp[i+1][j+1] = dp[i][j+1] ^ dp[i+1][j] ^ dp[i][j] ^ matrix[i][j];
                q.push(dp[i+1][j+1]);
                if (q.size() > k) {
                    q.pop();
                }
            }
        }
        return q.top();
    }
};