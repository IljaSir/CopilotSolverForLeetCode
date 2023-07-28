class Solution {
public:
    int latestDayToCross(int row, int col, vector<vector<int>>& cells) {
        
        int n = cells.size();
        vector<int> p(row * col + 1, 0);
        iota(p.begin(), p.end(), 0);
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int x = cells[i][0] - 1;
            int y = cells[i][1] - 1;
            int id = x * col + y;
            p[id] = id;
            if (x > 0 && p[id - col] != id - col) {
                p[find(id, p)] = find(id - col, p);
            }
            if (x < row - 1 && p[id + col] != id + col) {
                p[find(id, p)] = find(id + col, p);
            }
            if (y > 0 && p[id - 1] != id - 1) {
                p[find(id, p)] = find(id - 1, p);
            }
            if (y < col - 1 && p[id + 1] != id + 1) {
                p[find(id, p)] = find(id + 1, p);
            }
            if (find(0, p) == find(row * col - 1, p)) {
                ans = i + 1;
            }
        }
        return ans;
    }
};