class Solution {
public:
    int maxSideLength(vector<vector<int>>& mat, int threshold) {
        
        int m = mat.size(), n = mat[0].size();
        vector<vector<int>> sum(m + 1, vector<int>(n + 1, 0));
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }
        int l = 0, r = min(m, n);
        while (l < r) {
            int mid = l + r + 1 >> 1;
            bool ok = false;
            for (int i = mid; i <= m; ++i) {
                for (int j = mid; j <= n; ++j) {
                    int cur = sum[i][j] - sum[i - mid][j] - sum[i][j - mid] + sum[i - mid][j - mid];
                    if (cur <= threshold) {
                        ok = true;
                    }
                }
            }
            if (ok) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
};