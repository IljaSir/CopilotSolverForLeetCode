class Solution {
public:
    vector<vector<int>> imageSmoother(vector<vector<int>>& img) {
        
        int m = img.size();
        int n = img[0].size();
        vector<vector<int>> res(m, vector<int>(n));
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int sum = img[i][j];
                int count = 1;
                if (i > 0) {
                    sum += img[i - 1][j];
                    ++count;
                }
                if (i < m - 1) {
                    sum += img[i + 1][j];
                    ++count;
                }
                if (j > 0) {
                    sum += img[i][j - 1];
                    ++count;
                }
                if (j < n - 1) {
                    sum += img[i][j + 1];
                    ++count;
                }
                if (i > 0 && j > 0) {
                    sum += img[i - 1][j - 1];
                    ++count;
                }
                if (i > 0 && j < n - 1) {
                    sum += img[i - 1][j + 1];
                    ++count;
                }
                if (i < m - 1 && j > 0) {
                    sum += img[i + 1][j - 1];
                    ++count;
                }
                if (i < m - 1 && j < n - 1) {
                    sum += img[i + 1][j + 1];
                    ++count;
                }
                res[i][j] = sum / count;
            }
        }
        return res;
    }
};