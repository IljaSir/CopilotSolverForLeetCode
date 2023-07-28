class Solution {
public:
    int minimumTime(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<int>> visited(m, vector<int>(n, 0));
        priority_queue<pair<int, pair<int, int>>, vector<pair<int, pair<int, int>>>, greater<pair<int, pair<int, int>>>> pq;
        pq.push({0, {0, 0}});
        while (!pq.empty()) {
            auto [time, pos] = pq.top();
            pq.pop();
            int i = pos.first;
            int j = pos.second;
            if (i == m - 1 && j == n - 1) {
                return time;
            }
            if (visited[i][j]) {
                continue;
            }
            visited[i][j] = 1;
            if (i - 1 >= 0 && !visited[i - 1][j]) {
                pq.push({max(time, grid[i - 1][j]), {i - 1, j}});
            }
            if (i + 1 < m && !visited[i + 1][j]) {
                pq.push({max(time, grid[i + 1][j]), {i + 1, j}});
            }
            if (j - 1 >= 0 && !visited[i][j - 1]) {
                pq.push({max(time, grid[i][j - 1]), {i, j - 1}});
            }
            if (j + 1 < n && !visited[i][j + 1]) {
                pq.push({max(time, grid[i][j + 1]), {i, j + 1}});
            }
        }
        return -1;
    }
};