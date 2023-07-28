class Solution {
public:
    int minimumMoves(vector<vector<int>>& grid) {
        
        int n = grid.size();
        queue<pair<int, int>> q;
        unordered_set<string> visited;
        q.push({0, 0});
        visited.insert("0,0");
        int steps = 0;
        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                auto p = q.front();
                q.pop();
                int x = p.first;
                int y = p.second;
                if (x == n - 1 && y == n - 2) return steps;
                if (x + 1 < n && grid[x + 1][y] == 0) {
                    int nextX = x + 1;
                    int nextY = y;
                    if (visited.count(to_string(nextX) + "," + to_string(nextY))) continue;
                    q.push({nextX, nextY});
                    visited.insert(to_string(nextX) + "," + to_string(nextY));
                }
                if (y + 1 < n && grid[x][y + 1] == 0) {
                    int nextX = x;
                    int nextY = y + 1;
                    if (visited.count(to_string(nextX) + "," + to_string(nextY))) continue;
                    q.push({nextX, nextY});
                    visited.insert(to_string(nextX) + "," + to_string(nextY));
                }
                if (x + 1 < n && y + 1 < n && grid[x][y + 1] == 0 && grid[x + 1][y] == 0 && grid[x + 1][y + 1] == 0) {
                    int nextX = x;
                    int nextY = y + 1;
                    if (visited.count(to_string(nextX) + "," + to_string(nextY))) continue;
                    q.push({nextX, nextY});
                    visited.insert(to_string(nextX) + "," + to_string(nextY));
                }
                if (y + 1 < n && grid[x][y + 1] == 0 && grid[x + 1][y + 1] == 0) {
                    int nextX = x + 1;
                    int nextY = y;
                    if (visited.count(to_string(nextX) + "," + to_string(nextY))) continue;
                    q.push({
    }
};