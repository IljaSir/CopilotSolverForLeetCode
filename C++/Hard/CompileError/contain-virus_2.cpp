class Solution {
public:
    int containVirus(vector<vector<int>>& isInfected) {
        
        int m = isInfected.size();
        int n = isInfected[0].size();
        int total = 0;
        while (true) {
            vector<vector<bool>> visited(m, vector<bool>(n, false));
            vector<vector<int>> infected(m, vector<int>(n, 0));
            vector<vector<int>> walls(m, vector<int>(n, 0));
            vector<vector<int>> queue;
            int maxInfected = 0;
            int maxInfectedI = -1;
            int maxInfectedJ = -1;
            int maxWalls = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (isInfected[i][j] == 1 && !visited[i][j]) {
                        int infectedCount = 0;
                        int wallsCount = 0;
                        queue.clear();
                        queue.push_back({i, j});
                        visited[i][j] = true;
                        while (!queue.empty()) {
                            auto& node = queue.back();
                            queue.pop_back();
                            int x = node[0];
                            int y = node[1];
                            if (isInfected[x][y] == 1) {
                                infectedCount++;
                                if (x > 0 && !visited[x - 1][y]) {
                                    queue.push_back({x - 1, y});
                                    visited[x - 1][y] = true;
                                }
                                if (x < m - 1 && !visited[x + 1][y]) {
                                    queue.push_back({x + 1, y});
                                    visited[x + 1][y] = true;
                                }
                                if (y > 0 && !visited[x][y - 1]) {
                                    queue.push_back({x, y - 1});
                                    visited[x][y - 1] = true;
                                }
                                if (y < n - 1 && !visited[x][y + 1]) {
                                    queue.push_back({x, y + 1});
                                    visited[x][y + 1] = true;
                                }
                            } else {
                                wallsCount++;
                                if (x > 0 && isInfected[x - 1][y] == 0 && !visited[x - 1][y]) {
                                    queue.push_back({x -
    }
};