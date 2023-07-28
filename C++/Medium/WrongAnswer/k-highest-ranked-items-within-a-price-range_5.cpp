class Solution {
public:
    vector<vector<int>> highestRankedKItems(vector<vector<int>>& grid, vector<int>& pricing, vector<int>& start, int k) {
        
        vector<vector<int>> result;
        int m = grid.size(), n = grid[0].size();
        vector<vector<int>> visited(m, vector<int>(n, 0));
        priority_queue<vector<int>, vector<vector<int>>, greater<vector<int>>> pq;
        pq.push({0, start[0], start[1]});
        while (!pq.empty()) {
            auto curr = pq.top();
            pq.pop();
            int r = curr[1], c = curr[2];
            if (visited[r][c]) continue;
            visited[r][c] = 1;
            if (grid[r][c] >= pricing[0] && grid[r][c] <= pricing[1]) {
                result.push_back({r, c});
                if (result.size() == k) break;
            }
            if (r > 0 && !visited[r-1][c] && grid[r-1][c] > 0) pq.push({curr[0]+1, r-1, c});
            if (r < m-1 && !visited[r+1][c] && grid[r+1][c] > 0) pq.push({curr[0]+1, r+1, c});
            if (c > 0 && !visited[r][c-1] && grid[r][c-1] > 0) pq.push({curr[0]+1, r, c-1});
            if (c < n-1 && !visited[r][c+1] && grid[r][c+1] > 0) pq.push({curr[0]+1, r, c+1});
        }
        return result;
    }
};