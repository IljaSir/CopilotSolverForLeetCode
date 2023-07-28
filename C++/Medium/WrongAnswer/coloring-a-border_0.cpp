class Solution {
public:
    vector<vector<int>> colorBorder(vector<vector<int>>& grid, int row, int col, int color) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<int>> visited(m, vector<int>(n, 0));
        queue<pair<int, int>> q;
        q.push(make_pair(row, col));
        visited[row][col] = 1;
        int cur_color = grid[row][col];
        while (!q.empty()) {
            pair<int, int> p = q.front();
            q.pop();
            int i = p.first;
            int j = p.second;
            if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                grid[i][j] = color;
                continue;
            }
            if (grid[i - 1][j] != cur_color || grid[i + 1][j] != cur_color || grid[i][j - 1] != cur_color || grid[i][j + 1] != cur_color) {
                grid[i][j] = color;
                continue;
            }
            if (visited[i - 1][j] == 0) {
                q.push(make_pair(i - 1, j));
                visited[i - 1][j] = 1;
            }
            if (visited[i + 1][j] == 0) {
                q.push(make_pair(i + 1, j));
                visited[i + 1][j] = 1;
            }
            if (visited[i][j - 1] == 0) {
                q.push(make_pair(i, j - 1));
                visited[i][j - 1] = 1;
            }
            if (visited[i][j + 1] == 0) {
                q.push(make_pair(i, j + 1));
                visited[i][j + 1] = 1;
            }
        }
        return grid;
    }
};