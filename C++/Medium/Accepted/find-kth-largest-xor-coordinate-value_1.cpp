class Solution {
public:
    int kthLargestValue(vector<vector<int>>& matrix, int k) {
        
        int m = matrix.size();
        int n = matrix[0].size();
        vector<vector<int>> dp(m+1, vector<int>(n+1, 0));
        priority_queue<int, vector<int>, greater<int>> pq;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i-1][j] ^ dp[i][j-1] ^ dp[i-1][j-1] ^ matrix[i-1][j-1];
                pq.push(dp[i][j]);
                if (pq.size() > k) pq.pop();
            }
        }
        return pq.top();
    }
};