class Solution {
public:
    vector<vector<int>> highestRankedKItems(vector<vector<int>>& grid, vector<int>& pricing, vector<int>& start, int k) {
        
        int m = grid.size();
        int n = grid[0].size();
        int low = pricing[0];
        int high = pricing[1];
        vector<vector<int>> result;
        vector<vector<bool>> visited(m, vector<bool>(n, false));
        priority_queue<vector<int>, vector<vector<int>>, greater<vector<int>>> pq;
        int x = start[0];
        int y = start[1];
        pq.push({0, grid[x][y], x, y});
        while(!pq.empty()) {
            vector<int> top = pq.top();
            pq.pop();
            int dis = top[0];
            int price = top[1];
            int x = top[2];
            int y = top[3];
            if (price < low) {
                continue;
            }
            if (price > high) {
                break;
            }
            if (visited[x][y]) {
                continue;
            }
            result.push_back({x, y});
            if (result.size() == k) {
                break;
            }
            visited[x][y] = true;
            if (x > 0 && !visited[x - 1][y]) {
                pq.push({dis + 1, grid[x - 1][y], x - 1, y});
            }
            if (y > 0 && !visited[x][y - 1]) {
                pq.push({dis + 1, grid[x][y - 1], x, y - 1});
            }
            if (x < m - 1 && !visited[x + 1][y]) {
                pq.push({dis + 1, grid[x + 1][y], x + 1, y});
            }
            if (y < n - 1 && !visited[x][y + 1]) {
                pq.push({dis + 1, grid[x][y + 1], x, y + 1});
            }
        }
        return result;
    }
};