class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        
        int m = image.size();
        int n = image[0].size();
        int src = image[sr][sc];
        if (src == color) return image;
        vector<vector<int>> visited(m, vector<int>(n, 0));
        queue<pair<int, int>> q;
        q.push({sr, sc});
        visited[sr][sc] = 1;
        while (!q.empty()) {
            int x = q.front().first;
            int y = q.front().second;
            q.pop();
            image[x][y] = color;
            if (x > 0 && image[x - 1][y] == src && !visited[x - 1][y]) {
                q.push({x - 1, y});
                visited[x - 1][y] = 1;
            }
            if (x < m - 1 && image[x + 1][y] == src && !visited[x + 1][y]) {
                q.push({x + 1, y});
                visited[x + 1][y] = 1;
            }
            if (y > 0 && image[x][y - 1] == src && !visited[x][y - 1]) {
                q.push({x, y - 1});
                visited[x][y - 1] = 1;
            }
            if (y < n - 1 && image[x][y + 1] == src && !visited[x][y + 1]) {
                q.push({x, y + 1});
                visited[x][y + 1] = 1;
            }
        }
        return image;
    }
};