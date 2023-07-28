class Solution {
public:
    vector<int> findPeakGrid(vector<vector<int>>& mat) {
        
        int m = mat.size();
        int n = mat[0].size();
        int l = 0;
        int r = m - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int col = 0;
            for (int i = 0; i < n; ++i) {
                if (mat[mid][i] > mat[mid][col]) {
                    col = i;
                }
            }
            if (mat[mid][col] > mat[mid - 1][col] && mat[mid][col] > mat[mid + 1][col]) {
                return {mid, col};
            } else if (mat[mid][col] < mat[mid - 1][col]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return {l, 0};
    }
};