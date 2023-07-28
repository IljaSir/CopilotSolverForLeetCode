class Solution {
public:
    int latestDayToCross(int row, int col, vector<vector<int>>& cells) {
        
        int n = cells.size();
        vector<int> parent(row * col + 1, 0);
        for (int i = 1; i <= row * col; i++) {
            parent[i] = i;
        }
        vector<vector<int>> grid(row, vector<int>(col, 0));
        int res = 0;
        for (int i = 0; i < n; i++) {
            int x = cells[i][0] - 1;
            int y = cells[i][1] - 1;
            grid[x][y] = 1;
            if (x == 0) {
                Union(x * col + y + 1, 0, parent);
            }
            if (x == row - 1) {
                Union(x * col + y + 1, row * col + 1, parent);
            }
            int dir[4][2] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            for (int j = 0; j < 4; j++) {
                int nx = x + dir[j][0];
                int ny = y + dir[j][1];
                if (nx >= 0 && nx < row && ny >= 0 && ny < col && grid[nx][ny] == 1) {
                    Union(x * col + y + 1, nx * col + ny + 1, parent);
                }
            }
            if (Find(0, parent) == Find(row * col + 1, parent)) {
                res = i + 1;
            }
        }
        return res;
    }
    int Find(int x, vector<int>& parent) {
        if (parent[x] != x) {
            parent[x] = Find(parent[x], parent);
        }
        return parent[x];
    }
    void Union(int x, int y, vector<int>& parent) {
        int fx = Find(x, parent);
        int fy = Find(y, parent);
        if (fx != fy) {
            parent[fx] = fy;
        }
    }
};