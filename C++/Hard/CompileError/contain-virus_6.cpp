class Solution {
public:
    int containVirus(vector<vector<int>>& isInfected) {
        
        int m = isInfected.size();
        int n = isInfected[0].size();
        int res = 0;
        while (true) {
            vector<vector<int>> borders;
            vector<int> areas;
            vector<vector<int>> fronts;
            vector<int> front_areas;
            vector<vector<int>> visited(m, vector<int>(n, 0));
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (isInfected[i][j] == 1 && visited[i][j] == 0) {
                        vector<int> border;
                        int area = 0;
                        vector<int> front;
                        int front_area = 0;
                        queue<pair<int, int>> q;
                        q.push({i, j});
                        visited[i][j] = 1;
                        while (!q.empty()) {
                            auto [x, y] = q.front();
                            q.pop();
                            ++area;
                            int cnt = 0;
                            for (int k = 0; k < 4; ++k) {
                                int nx = x + dx[k];
                                int ny = y + dy[k];
                                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                                    if (isInfected[nx][ny] == 0) {
                                        ++cnt;
                                        if (visited[nx][ny] == 0) {
                                            visited[nx][ny] = 1;
                                            q.push({nx, ny});
                                        }
                                    }
                                    else if (isInfected[nx][ny] == 1 && visited[nx][ny] == 0) {
                                        visited[nx][ny] = 1;
                                        q.push({nx, ny});
                                    }
                                }
                            }
                            if (cnt > 0) {
                                ++front_area;
                                front.push_back(x * n + y);
                                if (cnt == 1) {
                                    border.push_back(x * n + y);
                                }
                            }
                        }
                        borders.push_back(border);
                        areas.push_back(area);
                        fronts.push_back(front);
                        front_areas.push_back(front_area);
                    }
                }
            }
            if (borders.empty()) {
                break;
            }
            int max_area = 0;
            int max_idx = 0;
    }
};