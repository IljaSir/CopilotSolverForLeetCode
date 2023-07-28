class Solution {
public:
    vector<vector<int>> imageSmoother(vector<vector<int>>& img) {
        
        const int n = img.size();
        const int m = img[0].size();
        vector<vector<int>> result(n, vector<int>(m, 0));
        int count = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                count = 0;
                for (int x = i - 1; x <= i + 1; ++x) {
                    for (int y = j - 1; y <= j + 1; ++y) {
                        if (x >= 0 && x < n && y >= 0 && y < m) {
                            result[i][j] += img[x][y];
                            ++count;
                        }
                    }
                }
                result[i][j] /= count;
            }
        }
        return result;
    }
};