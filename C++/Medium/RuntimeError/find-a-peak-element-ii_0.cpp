class Solution {
public:
    vector<int> findPeakGrid(vector<vector<int>>& mat) {
        
        int m = mat.size(), n = mat[0].size();
        int l = 0, r = m - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int maxj = 0;
            for (int j = 1; j < n; ++j) {
                if (mat[mid][j] > mat[mid][maxj])
                    maxj = j;
            }
            if (mat[mid][maxj] > mat[mid - 1][maxj] && mat[mid][maxj] > mat[mid + 1][maxj])
                return {mid, maxj};
            else if (mat[mid][maxj] < mat[mid - 1][maxj])
                r = mid - 1;
            else
                l = mid + 1;
        }
        int maxj = 0;
        for (int j = 1; j < n; ++j) {
            if (mat[l][j] > mat[l][maxj])
                maxj = j;
        }
        return {l, maxj};
    }
};