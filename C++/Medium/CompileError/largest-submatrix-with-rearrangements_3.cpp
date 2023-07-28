class Solution {
public:
    int largestSubmatrix(vector<vector<int>>& matrix) {
        
        int m = matrix.size();
        int n = matrix[0].size();
        vector<int> height(n, 0);
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j]) {
                    ++height[j];
                } else {
                    height[j] = 0;
                }
            }
            ans = max(ans, largestRectangleArea(height));
        }
        return ans;
    }
};