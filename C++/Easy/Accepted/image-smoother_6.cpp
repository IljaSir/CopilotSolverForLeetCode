class Solution {
public:
    vector<vector<int>> imageSmoother(vector<vector<int>>& img) {
        
        const int m = img.size();
        const int n = img[0].size();
        vector<vector<int>> ans(m, vector<int>(n, 0));
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int count = 0;
                for (int x = i - 1; x <= i + 1; ++x) {
                    for (int y = j - 1; y <= j + 1; ++y) {
                        if (x >= 0 && x < m && y >= 0 && y < n) {
                            ans[i][j] += img[x][y];
                            ++count;
                        }
                    }
                }
                ans[i][j] /= count;
            }
        }
        return ans;
    }
};