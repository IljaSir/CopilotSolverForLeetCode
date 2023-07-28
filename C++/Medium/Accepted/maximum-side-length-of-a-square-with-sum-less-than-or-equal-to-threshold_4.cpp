class Solution {
public:
    int maxSideLength(vector<vector<int>>& mat, int threshold) {
        
        int m = mat.size();
        int n = mat[0].size();
        vector<vector<int>> sums(m + 1, vector<int>(n + 1, 0));
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sums[i][j] = sums[i][j - 1] + sums[i - 1][j] - sums[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }
        int l = 0, r = min(m, n);
        while (l < r) {
            int mid = (l + r + 1) / 2;
            bool found = false;
            for (int i = mid; i <= m; i++) {
                for (int j = mid; j <= n; j++) {
                    int area = sums[i][j] - sums[i - mid][j] - sums[i][j - mid] + sums[i - mid][j - mid];
                    if (area <= threshold) {
                        found = true;
                        break;
                    }
                }
                if (found) {
                    break;
                }
            }
            if (found) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
};