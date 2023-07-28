class Solution {
public:
    vector<vector<int>> imageSmoother(vector<vector<int>>& img) {
        
        int m = img.size(), n = img[0].size();
        vector<vector<int>> ans(m, vector<int>(n));
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int sum = 0, count = 0;
                for (int x = -1; x <= 1; ++x) {
                    for (int y = -1; y <= 1; ++y) {
                        int nx = i + x, ny = j + y;
                        if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                            sum += img[nx][ny];
                            count++;
                        }
                    }
                }
                ans[i][j] = sum / count;
            }
        }
        return ans;
    }
};