class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        
        int m = image.size();
        int n = image[0].size();
        int old_color = image[sr][sc];
        if (old_color == color) return image;
        queue<pair<int, int>> q;
        q.push({sr, sc});
        while (!q.empty()) {
            auto [x, y] = q.front();
            q.pop();
            if (image[x][y] == old_color) {
                image[x][y] = color;
                if (x > 0) q.push({x-1, y});
                if (x < m - 1) q.push({x+1, y});
                if (y > 0) q.push({x, y-1});
                if (y < n - 1) q.push({x, y+1});
            }
        }
        return image;
    }
};