class Solution {
public:
    vector<vector<int>> highestRankedKItems(vector<vector<int>>& grid, vector<int>& pricing, vector<int>& start, int k) {
        
        int m = grid.size(), n = grid[0].size();
        int low = pricing[0], high = pricing[1];
        int x = start[0], y = start[1];
        vector<vector<int>> res;
        vector<vector<int>> visited(m, vector<int>(n, 0));
        priority_queue<pair<int, pair<int, int>>> pq; // price, position
        pq.push({grid[x][y], {x, y}});
        while (!pq.empty() && k > 0) {
            auto p = pq.top();
            pq.pop();
            int price = p.first, i = p.second.first, j = p.second.second;
            if (price < low || price > high) continue;
            if (visited[i][j]) continue;
            visited[i][j] = 1;
            res.push_back({i, j});
            k--;
            if (i > 0 && !visited[i-1][j]) pq.push({grid[i-1][j], {i-1, j}});
            if (i < m - 1 && !visited[i+1][j]) pq.push({grid[i+1][j], {i+1, j}});
            if (j > 0 && !visited[i][j-1]) pq.push({grid[i][j-1], {i, j-1}});
            if (j < n - 1 && !visited[i][j+1]) pq.push({grid[i][j+1], {i, j+1}});
        }
        return res;
    }
};