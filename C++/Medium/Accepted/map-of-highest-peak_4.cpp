class Solution {
public:
    vector<vector<int>> highestPeak(vector<vector<int>>& isWater) {
        
        int m = isWater.size();
        int n = isWater[0].size();
        vector<vector<int>> height(m, vector<int>(n, 0));
        queue<pair<int, int>> q;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (isWater[i][j] == 1) {
                    q.push({i, j});
                    isWater[i][j] = 2;
                }
            }
        }
        while (!q.empty()) {
            auto p = q.front();
            q.pop();
            int i = p.first;
            int j = p.second;
            if (i > 0 && isWater[i - 1][j] == 0) {
                height[i - 1][j] = height[i][j] + 1;
                isWater[i - 1][j] = 2;
                q.push({i - 1, j});
            }
            if (i < m - 1 && isWater[i + 1][j] == 0) {
                height[i + 1][j] = height[i][j] + 1;
                isWater[i + 1][j] = 2;
                q.push({i + 1, j});
            }
            if (j > 0 && isWater[i][j - 1] == 0) {
                height[i][j - 1] = height[i][j] + 1;
                isWater[i][j - 1] = 2;
                q.push({i, j - 1});
            }
            if (j < n - 1 && isWater[i][j + 1] == 0) {
                height[i][j + 1] = height[i][j] + 1;
                isWater[i][j + 1] = 2;
                q.push({i, j + 1});
            }
        }
        return height;
    }
};