class Solution {
public:
    vector<vector<int>> highestPeak(vector<vector<int>>& isWater) {
        
        int m = isWater.size();
        int n = isWater[0].size();
        vector<vector<int>> res(m, vector<int>(n, -1));
        queue<pair<int, int>> q;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    q.push({i, j});
                    res[i][j] = 0;
                }
            }
        }
        while (!q.empty()) {
            auto p = q.front();
            q.pop();
            int x = p.first;
            int y = p.second;
            int val = res[x][y] + 1;
            if (x > 0 && res[x-1][y] == -1) {
                res[x-1][y] = val;
                q.push({x-1, y});
            }
            if (x < m-1 && res[x+1][y] == -1) {
                res[x+1][y] = val;
                q.push({x+1, y});
            }
            if (y > 0 && res[x][y-1] == -1) {
                res[x][y-1] = val;
                q.push({x, y-1});
            }
            if (y < n-1 && res[x][y+1] == -1) {
                res[x][y+1] = val;
                q.push({x, y+1});
            }
        }
        return res;
    }
};