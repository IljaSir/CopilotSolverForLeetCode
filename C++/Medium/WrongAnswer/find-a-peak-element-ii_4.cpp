class Solution {
public:
    vector<int> findPeakGrid(vector<vector<int>>& mat) {
        
        int m = mat.size(), n = mat[0].size();
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int row = 0;
            for (int i = 0; i < m; i++) {
                if (mat[i][mid] > mat[row][mid]) {
                    row = i;
                }
            }
            if (mid > 0 && mat[row][mid] < mat[row][mid - 1]) {
                r = mid - 1;
            } else if (mid < n - 1 && mat[row][mid] < mat[row][mid + 1]) {
                l = mid + 1;
            } else {
                return {row, mid};
            }
        }
        return {0, l};
    }
};