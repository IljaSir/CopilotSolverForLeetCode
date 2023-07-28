class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        
        int m = matrix.size();
        int n = matrix[0].size();
        vector<int> res;
        int left = 0, right = n - 1, top = 0, bottom = m - 1;
        while (left <= right && top <= bottom) {
            for (int col = left; col <= right; col++) {
                res.push_back(matrix[top][col]);
            }
            for (int row = top + 1; row <= bottom; row++) {
                res.push_back(matrix[row][right]);
            }
            if (left < right && top < bottom) {
                for (int col = right - 1; col > left; col--) {
                    res.push_back(matrix[bottom][col]);
                }
                for (int row = bottom; row > top; row--) {
                    res.push_back(matrix[row][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return res;
    }
};