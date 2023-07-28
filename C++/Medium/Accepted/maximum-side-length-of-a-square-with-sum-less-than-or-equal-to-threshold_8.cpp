class Solution {
public:
    int maxSideLength(vector<vector<int>>& mat, int threshold) {
        
        int m = mat.size();
        int n = mat[0].size();
        int ans = 0;
        int sum[m + 1][n + 1];
        memset(sum, 0, sizeof(sum));
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                sum[i][j] = mat[i - 1][j - 1] + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
            }
        }
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                int k = min(m - i + 1, n - j + 1);
                while(k > ans) {
                    int t = sum[i + k - 1][j + k - 1] - sum[i - 1][j + k - 1] - sum[i + k - 1][j - 1] + sum[i - 1][j - 1];
                    if(t <= threshold) {
                        ans = k;
                        break;
                    }
                    k--;
                }
            }
        }
        return ans;
    }
};