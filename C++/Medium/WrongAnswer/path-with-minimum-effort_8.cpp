class Solution {
public:
    int minimumEffortPath(vector<vector<int>>& heights) {
        
        int rows = heights.size();
        int cols = heights[0].size();
        int result = 0;
        vector<vector<bool>> visited(rows, vector<bool>(cols, false));
        vector<vector<int>> directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        queue<pair<int, int>> q;
        q.push({0, 0});
        visited[0][0] = true;
        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                auto [x, y] = q.front();
                q.pop();
                if (x == rows - 1 && y == cols - 1) {
                    return result;
                }
                for (auto& direction : directions) {
                    int nx = x + direction[0];
                    int ny = y + direction[1];
                    if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && !visited[nx][ny]) {
                        int diff = abs(heights[nx][ny] - heights[x][y]);
                        if (diff <= result) {
                            q.push({nx, ny});
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
            result++;
        }
        return result;
    }
};