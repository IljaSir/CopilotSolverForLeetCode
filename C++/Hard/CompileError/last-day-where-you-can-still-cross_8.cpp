class Solution {
public:
    int latestDayToCross(int row, int col, vector<vector<int>>& cells) {
        
        int n = cells.size();
        vector<vector<int>> grid(row, vector<int>(col, 0));
        vector<int> parent(n, -1);
        vector<int> rank(n, 0);
        vector<int> dir = {0, 1, 0, -1, 0};
        for (int i = 0; i < n; i++) {
            int r = cells[i][0] - 1;
            int c = cells[i][1] - 1;
            grid[r][c] = 1;
            int id = r * col + c;
            parent[id] = id;
            for (int j = 0; j < 4; j++) {
                int nr = r + dir[j];
                int nc = c + dir[j + 1];
                if (nr >= 0 && nr < row && nc >= 0 && nc < col && grid[nr][nc] == 1) {
                    int nid = nr * col + nc;
                    union_(parent, rank, id, nid);
                }
            }
            if (r == 0) {
                for (int j = 0; j < col; j++) {
                    if (grid[0][j] == 1) {
                        union_(parent, rank, 0, j);
                    }
                }
            }
            if (r == row - 1) {
                for (int j = 0; j < col; j++) {
                    if (grid[row - 1][j] == 1) {
                        union_(parent, rank, id, (row - 1) * col + j);
                    }
                }
            }
            if (find(parent, 0) == find(parent, (row - 1) * col + col - 1)) {
                return n - i - 1;
            }
        }
        return 0;
    }
};