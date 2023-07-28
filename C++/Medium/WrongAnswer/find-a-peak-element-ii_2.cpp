class Solution {
public:
    vector<int> findPeakGrid(vector<vector<int>>& mat) {
        
        int m = mat.size();
        int n = mat[0].size();
        int l = 0, r = m - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int maxCol = 0;
            for (int i = 0; i < n; i++) {
                if (mat[mid][i] > mat[mid][maxCol]) {
                    maxCol = i;
                }
            }
            if (mid > 0 && mat[mid][maxCol] < mat[mid - 1][maxCol]) {
                r = mid - 1;
            } else if (mid < m - 1 && mat[mid][maxCol] < mat[mid + 1][maxCol]) {
                l = mid + 1;
            } else {
                return {mid, maxCol};
            }
        }
        return {l, 0};
    }
};