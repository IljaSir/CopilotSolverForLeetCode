class Solution {
public:
    int maxSideLength(vector<vector<int>>& mat, int threshold) {
        
        int m = mat.size();
        int n = mat[0].size();
        vector<vector<int>> sum(m + 1, vector<int>(n + 1, 0));
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }
        int ans = 0;
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                int l = ans + 1;
                int r = min(m - i + 1, n - j + 1);
                while (l <= r) {
                    int mid = l + (r - l) / 2;
                    if (sum[i + mid - 1][j + mid - 1] - sum[i + mid - 1][j - 1] - sum[i - 1][j + mid - 1] + sum[i - 1][j - 1] > threshold) {
                        r = mid - 1;
                    } else {
                        ans = mid;
                        l = mid + 1;
                    }
                }
            }
        }
        return ans;
    }
};