class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        
        int M = matrix.size();
        int N = matrix[0].size();
        int i = 0, j = N - 1;
        while (i < M && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
};