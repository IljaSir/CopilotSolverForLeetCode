class Solution {
public:
    int longestIncreasingPath(vector<vector<int>>& matrix) {
        
        int m = matrix.size();
        if (m == 0) return 0;
        int n = matrix[0].size();
        vector<vector<int>> dp(m, vector<int>(n, 0));
        int max_len = 1;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                max_len = max(max_len, dfs(matrix, dp, i, j));
            }
        }
        return max_len;
    }
};