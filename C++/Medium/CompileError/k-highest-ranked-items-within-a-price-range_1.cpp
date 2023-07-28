class Solution {
public:
    vector<vector<int>> highestRankedKItems(vector<vector<int>>& grid, vector<int>& pricing, vector<int>& start, int k) {
        
        int m = grid.size(), n = grid[0].size();
        int low = pricing[0], high = pricing[1];
        int x = start[0], y = start[1];
        vector<vector<int>> ans;
        priority_queue<tuple<int, int, int, int>> pq;
        pq.push({0, grid[x][y], x, y});
        grid[x][y] = -1;
        while (!pq.empty() && ans.size() < k) {
            auto [dist, price, r, c] = pq.top();
            pq.pop();
            if (price < low || price > high) continue;
            ans.push_back({r, c});
            for (auto& [dx, dy] : vector<vector<int>>{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}) {
                int i = r + dx, j = c + dy;
                if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] <= 0) continue;
                pq.push({dist - 1, grid[i][j], i, j});
                grid[i][j] = -1;
            }
        }
        return ans;
    }
};