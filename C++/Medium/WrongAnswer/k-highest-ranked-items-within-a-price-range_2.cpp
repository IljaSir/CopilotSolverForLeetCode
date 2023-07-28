class Solution {
public:
    vector<vector<int>> highestRankedKItems(vector<vector<int>>& grid, vector<int>& pricing, vector<int>& start, int k) {
        
        int m = grid.size(), n = grid[0].size();
        int low = pricing[0], high = pricing[1];
        int r = start[0], c = start[1];
        vector<vector<int>> res;
        vector<vector<int>> dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        vector<vector<int>> visited(m, vector<int>(n, 0));
        priority_queue<vector<int>, vector<vector<int>>, greater<vector<int>>> pq;
        pq.push({0, grid[r][c], r, c});
        while (!pq.empty()) {
            auto t = pq.top();
            pq.pop();
            int dist = t[0], price = t[1], x = t[2], y = t[3];
            if (price < low || price > high || visited[x][y]) continue;
            visited[x][y] = 1;
            res.push_back({x, y});
            if (res.size() == k) break;
            for (auto dir : dirs) {
                int i = x + dir[0], j = y + dir[1];
                if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || grid[i][j] == 0) continue;
                pq.push({dist + 1, grid[i][j], i, j});
            }
        }
        return res;
    }
};