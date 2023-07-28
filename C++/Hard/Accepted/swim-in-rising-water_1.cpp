class Solution {
public:
    int swimInWater(vector<vector<int>>& grid) {
        
        int n = grid.size();
        vector<vector<int>> dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        vector<vector<bool>> visited(n, vector<bool>(n, false));
        pq.push({grid[0][0], 0});
        visited[0][0] = true;
        while (!pq.empty()) {
            auto [t, idx] = pq.top();
            pq.pop();
            int i = idx / n, j = idx % n;
            if (i == n - 1 && j == n - 1) {
                return t;
            }
            for (auto d : dir) {
                int ni = i + d[0], nj = j + d[1];
                if (ni >= 0 && ni < n && nj >= 0 && nj < n && !visited[ni][nj]) {
                    visited[ni][nj] = true;
                    pq.push({max(t, grid[ni][nj]), ni * n + nj});
                }
            }
        }
        return -1;
    }
};