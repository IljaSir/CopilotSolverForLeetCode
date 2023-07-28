class Solution {
public:
    vector<int> findPeakGrid(vector<vector<int>>& mat) {
        
        int m = mat.size(), n = mat[0].size();
        int l = 0, r = m - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            int col = 0;
            for (int j = 1; j < n; ++j) {
                if (mat[mid][j] > mat[mid][col]) {
                    col = j;
                }
            }
            if (mid > 0 && mat[mid][col] < mat[mid - 1][col]) {
                r = mid - 1;
            } else if (mid < m - 1 && mat[mid][col] < mat[mid + 1][col]) {
                l = mid + 1;
            } else {
                return {mid, col};
            }
        }
        return {};
    }
};