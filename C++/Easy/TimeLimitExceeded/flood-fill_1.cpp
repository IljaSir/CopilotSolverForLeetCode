class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        
        int m = image.size();
        int n = image[0].size();
        vector<vector<int>> dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        queue<pair<int, int>> q;
        q.push({sr, sc});
        int oldColor = image[sr][sc];
        image[sr][sc] = color;
        while (!q.empty()) {
            auto [x, y] = q.front();
            q.pop();
            for (auto d : dir) {
                int nx = x + d[0];
                int ny = y + d[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || image[nx][ny] != oldColor) {
                    continue;
                }
                image[nx][ny] = color;
                q.push({nx, ny});
            }
        }
        return image;
    }
};