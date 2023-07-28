class Solution {
public:
    int shortestPath(vector<vector<int>>& grid, int k) {
        
        int M = grid.size();
        int N = grid[0].size();
        vector<vector<int>> visited(M, vector<int>(N, -1));
        queue<vector<int>> q;
        q.push({0, 0, 0});
        visited[0][0] = 0;
        int steps = 0;
        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                auto cur = q.front();
                q.pop();
                if (cur[0] == M - 1 && cur[1] == N - 1) {
                    return steps;
                }
                for (int j = 0; j < 4; ++j) {
                    int x = cur[0] + dir[j][0];
                    int y = cur[1] + dir[j][1];
                    if (x < 0 || x >= M || y < 0 || y >= N) {
                        continue;
                    }
                    int obs = cur[2] + grid[x][y];
                    if (obs > k || (visited[x][y] != -1 && obs >= visited[x][y])) {
                        continue;
                    }
                    q.push({x, y, obs});
                    visited[x][y] = obs;
                }
            }
            ++steps;
        }
        return -1;
    }
};