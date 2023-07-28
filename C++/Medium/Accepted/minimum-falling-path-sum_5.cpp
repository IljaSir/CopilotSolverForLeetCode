class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
        
        int n = matrix.size();
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int left = j == 0 ? INT_MAX : matrix[i - 1][j - 1];
                int mid = matrix[i - 1][j];
                int right = j == n - 1 ? INT_MAX : matrix[i - 1][j + 1];
                matrix[i][j] += min(min(left, mid), right);
            }
        }
        int ans = INT_MAX;
        for (int j = 0; j < n; j++) {
            ans = min(ans, matrix[n - 1][j]);
        }
        return ans;
    }
};