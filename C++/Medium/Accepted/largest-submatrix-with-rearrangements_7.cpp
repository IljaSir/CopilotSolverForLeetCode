class Solution {
public:
    int largestSubmatrix(vector<vector<int>>& matrix) {
        
        int rows = matrix.size();
        int cols = matrix[0].size();
        int maxArea = 0;
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] += matrix[i - 1][j];
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            sort(matrix[i].begin(), matrix[i].end());
            for (int j = 0; j < cols; j++) {
                maxArea = max(maxArea, matrix[i][j] * (cols - j));
            }
        }
        return maxArea;
    }
};