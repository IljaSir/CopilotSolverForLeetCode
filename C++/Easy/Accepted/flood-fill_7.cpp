class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        
        int n = image.size();
        int m = image[0].size();
        vector<vector<bool>> vis(n, vector<bool>(m, false));
        int old_color = image[sr][sc];
        queue<pair<int, int>> q;
        q.push(make_pair(sr, sc));
        vis[sr][sc] = true;
        while(!q.empty()) {
            pair<int, int> p = q.front();
            q.pop();
            int x = p.first;
            int y = p.second;
            image[x][y] = color;
            if(x > 0 && image[x - 1][y] == old_color && !vis[x - 1][y]) {
                q.push(make_pair(x - 1, y));
                vis[x - 1][y] = true;
            }
            if(x < n - 1 && image[x + 1][y] == old_color && !vis[x + 1][y]) {
                q.push(make_pair(x + 1, y));
                vis[x + 1][y] = true;
            }
            if(y > 0 && image[x][y - 1] == old_color && !vis[x][y - 1]) {
                q.push(make_pair(x, y - 1));
                vis[x][y - 1] = true;
            }
            if(y < m - 1 && image[x][y + 1] == old_color && !vis[x][y + 1]) {
                q.push(make_pair(x, y + 1));
                vis[x][y + 1] = true;
            }
        }
        return image;
    }
};