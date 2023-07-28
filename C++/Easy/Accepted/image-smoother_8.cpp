class Solution {
public:
    vector<vector<int>> imageSmoother(vector<vector<int>>& img) {
        
        int m = img.size(), n = img[0].size();
        vector<vector<int>> res(m, vector<int>(n, 0));
        int dr[9] = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
        int dc[9] = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int sum = 0, cnt = 0;
                for (int k = 0; k < 9; ++k) {
                    int nr = i + dr[k], nc = j + dc[k];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                        sum += img[nr][nc];
                        cnt++;
                    }
                }
                res[i][j] = sum / cnt;
            }
        }
        return res;
    }
};