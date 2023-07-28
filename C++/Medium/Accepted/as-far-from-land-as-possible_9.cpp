class Solution {
public:
    int maxDistance(vector<vector<int>>& grid) {
        
        int N = grid.size();
        if (N <= 1) {
            return -1;
        }
        vector<vector<int>> distance(N, vector<int>(N, -1));
        queue<pair<int, int>> q;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    q.push(make_pair(i, j));
                    distance[i][j] = 0;
                }
            }
        }
        if (q.size() == N * N || q.empty()) {
            return -1;
        }
        int step = 0;
        while (!q.empty()) {
            int size = q.size();
            step++;
            for (int i = 0; i < size; i++) {
                auto [x, y] = q.front();
                q.pop();
                if (x - 1 >= 0 && distance[x - 1][y] == -1) {
                    q.push(make_pair(x - 1, y));
                    distance[x - 1][y] = step;
                }
                if (x + 1 < N && distance[x + 1][y] == -1) {
                    q.push(make_pair(x + 1, y));
                    distance[x + 1][y] = step;
                }
                if (y - 1 >= 0 && distance[x][y - 1] == -1) {
                    q.push(make_pair(x, y - 1));
                    distance[x][y - 1] = step;
                }
                if (y + 1 < N && distance[x][y + 1] == -1) {
                    q.push(make_pair(x, y + 1));
                    distance[x][y + 1] = step;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result = max(result, distance[i][j]);
            }
        }
        return result;
    }
};