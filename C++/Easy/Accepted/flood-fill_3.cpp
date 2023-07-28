class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        
        int m = image.size(), n = image[0].size();
        int old_color = image[sr][sc];
        if (old_color == color) return image;
        queue<pair<int, int>> q;
        q.push({sr, sc});
        while (!q.empty()) {
            auto p = q.front();
            q.pop();
            int x = p.first, y = p.second;
            image[x][y] = color;
            if (x > 0 && image[x - 1][y] == old_color) q.push({x - 1, y});
            if (x < m - 1 && image[x + 1][y] == old_color) q.push({x + 1, y});
            if (y > 0 && image[x][y - 1] == old_color) q.push({x, y - 1});
            if (y < n - 1 && image[x][y + 1] == old_color) q.push({x, y + 1});
        }
        return image;
    }
};