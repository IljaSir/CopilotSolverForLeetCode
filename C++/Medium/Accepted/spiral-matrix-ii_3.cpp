class Solution {
public:
    vector<vector<int>> generateMatrix(int n) {
        
        vector<vector<int>> ans(n, vector<int>(n, 0));
        int i = 0, j = 0, di = 0, dj = 1;
        for (int k = 1; k <= n * n; k++) {
            ans[i][j] = k;
            if (ans[(i + di + n) % n][(j + dj + n) % n] != 0) {
                int t = di;
                di = dj;
                dj = -t;
            }
            i += di;
            j += dj;
        }
        return ans;
    }
};