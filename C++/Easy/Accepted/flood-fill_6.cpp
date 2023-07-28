class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        
        int h = image.size(), w = image[0].size();
        int oldColor = image[sr][sc];
        if (oldColor == color) return image;
        queue<pair<int, int>> q;
        q.push({sr, sc});
        while (!q.empty()) {
            auto [x, y] = q.front();
            q.pop();
            if (image[x][y] == oldColor) {
                image[x][y] = color;
                if (x > 0) q.push({x - 1, y});
                if (x < h - 1) q.push({x + 1, y});
                if (y > 0) q.push({x, y - 1});
                if (y < w - 1) q.push({x, y + 1});
            }
        }
        return image;
    }
};