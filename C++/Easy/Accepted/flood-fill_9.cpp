class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        
        int m = image.size();
        int n = image[0].size();
        int oldColor = image[sr][sc];
        if (oldColor == color) return image;
        vector<vector<int>> dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        queue<pair<int, int>> q;
        q.push({sr, sc});
        image[sr][sc] = color;
        while (!q.empty()) {
            auto pos = q.front();
            q.pop();
            for (auto d : dir) {
                int x = pos.first + d[0];
                int y = pos.second + d[1];
                if (x >= 0 && x < m && y >= 0 && y < n && image[x][y] == oldColor) {
                    image[x][y] = color;
                    q.push({x, y});
                }
            }
        }
        return image;
    }
};