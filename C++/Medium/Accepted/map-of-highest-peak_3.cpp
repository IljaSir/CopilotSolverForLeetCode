class Solution {
public:
    vector<vector<int>> highestPeak(vector<vector<int>>& isWater) {
        
        int m = isWater.size(), n = isWater[0].size();
        vector<vector<int>> res(m, vector<int>(n));
        queue<pair<int, int>> q;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (isWater[i][j]) {
                    res[i][j] = 0;
                    q.push({i, j});
                }
                else res[i][j] = -1;
            }
        }
        while (!q.empty()) {
            auto p = q.front(); q.pop();
            int i = p.first, j = p.second;
            if (i && res[i - 1][j] == -1) {
                res[i - 1][j] = res[i][j] + 1;
                q.push({i - 1, j});
            }
            if (j && res[i][j - 1] == -1) {
                res[i][j - 1] = res[i][j] + 1;
                q.push({i, j - 1});
            }
            if (i < m - 1 && res[i + 1][j] == -1) {
                res[i + 1][j] = res[i][j] + 1;
                q.push({i + 1, j});
            }
            if (j < n - 1 && res[i][j + 1] == -1) {
                res[i][j + 1] = res[i][j] + 1;
                q.push({i, j + 1});
            }
        }
        return res;
    }
};