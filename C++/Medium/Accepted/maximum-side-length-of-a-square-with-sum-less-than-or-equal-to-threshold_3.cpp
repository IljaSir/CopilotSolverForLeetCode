class Solution {
public:
    int maxSideLength(vector<vector<int>>& mat, int threshold) {
        
        int m = mat.size(), n = mat[0].size();
        vector<vector<int>> sum(m+1, vector<int>(n+1, 0));
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + mat[i-1][j-1];
            }
        }
        int ans = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int l = 0, r = min(m - i + 1, n - j + 1);
                while (l < r) {
                    int mid = l + (r - l + 1) / 2;
                    if (sum[i+mid-1][j+mid-1] - sum[i-1][j+mid-1] - sum[i+mid-1][j-1] + sum[i-1][j-1] <= threshold) {
                        l = mid;
                    } else {
                        r = mid - 1;
                    }
                }
                ans = max(ans, l);
            }
        }
        return ans;
    }
};