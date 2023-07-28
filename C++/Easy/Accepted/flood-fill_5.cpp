class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        
        int m = image.size();
        int n = image[0].size();
        vector<vector<bool>> visited(m, vector<bool>(n, false));
        int old_color = image[sr][sc];
        queue<pair<int, int>> q;
        q.push(make_pair(sr, sc));
        while (!q.empty()) {
            pair<int, int> p = q.front();
            q.pop();
            int x = p.first;
            int y = p.second;
            if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || image[x][y] != old_color) {
                continue;
            }
            image[x][y] = color;
            visited[x][y] = true;
            q.push(make_pair(x - 1, y));
            q.push(make_pair(x + 1, y));
            q.push(make_pair(x, y - 1));
            q.push(make_pair(x, y + 1));
        }
        return image;
    }
};