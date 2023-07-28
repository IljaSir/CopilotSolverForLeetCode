class Solution {
public:
    int numSubmat(vector<vector<int>>& mat) {
        
        int m = mat.size();
        int n = mat[0].size();
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && mat[i][j] == 1) {
                    mat[i][j] += mat[i - 1][j];
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int minVal = INT_MAX;
                for (int k = i; k >= 0; k--) {
                    minVal = min(minVal, mat[k][j]);
                    ans += minVal;
                }
            }
        }
        return ans;
    }
};