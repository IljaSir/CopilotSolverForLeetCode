class Solution {
public:
    int latestDayToCross(int row, int col, vector<vector<int>>& cells) {
        
        int n = cells.size();
        vector<vector<int>> grid(row, vector<int>(col, 0));
        vector<vector<int>> parent(row * col, vector<int>(2, 0));
        for (int i = 0; i < row * col; i++) {
            parent[i][0] = i;
        }
        for (int i = 0; i < n; i++) {
            int x = cells[i][0] - 1;
            int y = cells[i][1] - 1;
            grid[x][y] = 1;
            int p = x * col + y;
            if (p < col) {
                parent[p][1] = 1;
            }
            if (x > 0 && grid[x - 1][y] == 1) {
                int q = (x - 1) * col + y;
                int p1 = find(parent, p);
                int q1 = find(parent, q);
                if (p1 != q1) {
                    parent[p1][0] = q1;
                    if (parent[p1][1] == 1 || parent[q1][1] == 1) {
                        parent[q1][1] = 1;
                    }
                }
            }
            if (x < row - 1 && grid[x + 1][y] == 1) {
                int q = (x + 1) * col + y;
                int p1 = find(parent, p);
                int q1 = find(parent, q);
                if (p1 != q1) {
                    parent[p1][0] = q1;
                    if (parent[p1][1] == 1 || parent[q1][1] == 1) {
                        parent[q1][1] = 1;
                    }
                }
            }
            if (y > 0 && grid[x][y - 1] == 1) {
                int q = x * col + y - 1;
                int p1 = find(parent, p);
                int q1 = find(parent, q);
                if (p1 != q1) {
                    parent[p1][0] = q1;
                    if (parent[p1][1] == 1 || parent[q1][1] == 1) {
                        parent[q1][1] = 1
    }
};