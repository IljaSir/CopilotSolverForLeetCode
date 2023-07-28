class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        
        int m = image.size(), n = image[0].size();
        vector<vector<int>> dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        queue<pair<int, int>> q;
        vector<vector<bool>> visited(m, vector<bool>(n, false));
        q.push({sr, sc});
        visited[sr][sc] = true;
        int old_color = image[sr][sc];
        while (!q.empty()) {
            auto [r, c] = q.front();
            q.pop();
            image[r][c] = color;
            for (auto& dir : dirs) {
                int nr = r + dir[0], nc = c + dir[1];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n || visited[nr][nc] || image[nr][nc] != old_color) continue;
                q.push({nr, nc});
                visited[nr][nc] = true;
            }
        }
        return image;
    }
};