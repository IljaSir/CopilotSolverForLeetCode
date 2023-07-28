class Solution {
public:
    vector<vector<int>> highestRankedKItems(vector<vector<int>>& grid, vector<int>& pricing, vector<int>& start, int k) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<int>> res;
        vector<vector<int>> dist(m, vector<int>(n, INT_MAX));
        dist[start[0]][start[1]] = 0;
        priority_queue<vector<int>, vector<vector<int>>, greater<vector<int>>> pq;
        pq.push({0, start[0], start[1]});
        while (!pq.empty()) {
            auto cur = pq.top();
            pq.pop();
            int d = cur[0];
            int x = cur[1];
            int y = cur[2];
            if (d > dist[x][y]) continue;
            if (pricing[0] <= grid[x][y] && grid[x][y] <= pricing[1]) {
                res.push_back({x, y});
                if (res.size() == k) return res;
            }
            for (int i = 0; i < 4; ++i) {
                int nx = x + dirs[i][0];
                int ny = y + dirs[i][1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] == 0 || d + 1 >= dist[nx][ny]) continue;
                dist[nx][ny] = d + 1;
                pq.push({d + 1, nx, ny});
            }
        }
        return res;
    }
};