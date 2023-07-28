class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        
        int m = matrix.size();
        int n = matrix[0].size();
        int l = 0;
        int r = m*n-1;
        while (l <= r) {
            int mid = (l+r)/2;
            int midVal = matrix[mid/n][mid%n];
            if (midVal == target) {
                return true;
            }
            if (midVal < target) {
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        return false;
    }
};