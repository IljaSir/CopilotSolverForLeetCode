class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        
        int m = matrix.size();
        int n = matrix[0].size();
        int left = 0;
        int right = m * n - 1;
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            if (matrix[mid / n][mid % n] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return matrix[left / n][left % n] == target;
    }
};