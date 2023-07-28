class Solution {
public:
    int latestDayToCross(int row, int col, vector<vector<int>>& cells) {
        
        int n = cells.size();
        vector<int> p(n);
        iota(p.begin(), p.end(), 0);
        vector<vector<int>> g(row * col);
        vector<int> in(row * col);
        vector<int> out(row * col);
        function<int(int)> find = [&](int x) {
            return p[x] == x ? x : p[x] = find(p[x]);
        };
        function<void(int, int)> merge = [&](int x, int y) {
            x = find(x);
            y = find(y);
            if (x != y) {
                p[x] = y;
            }
        };
        auto addEdge = [&](int x, int y) {
            g[x].push_back(y);
            ++in[y];
            ++out[x];
        };
        for (int i = 0; i < n; ++i) {
            int x = cells[i][0] - 1, y = cells[i][1] - 1;
            int u = x * col + y;
            if (x > 0) {
                int v = (x - 1) * col + y;
                if (find(u) != find(v)) {
                    addEdge(u, v);
                    addEdge(v, u);
                    merge(u, v);
                }
            }
            if (x + 1 < row) {
                int v = (x + 1) * col + y;
                if (find(u) != find(v)) {
                    addEdge(u, v);
                    addEdge(v, u);
                    merge(u, v);
                }
            }
            if (y > 0) {
                int v = x * col + (y - 1);
                if (find(u) != find(v)) {
                    addEdge(u, v);
                    addEdge(v, u);
                    merge(u, v);
                }
            }
            if (y + 1 < col) {
                int v = x * col + (y + 1);
                if (find(u) != find(v)) {
                    addEdge(u, v);
                    addEdge(v, u);
                    merge(u, v);
                }
            }
        }
        vector<int> q;
        for (int i = 0; i < row * col; ++i) {
            if (in[i] == 0) {
                q.push_back(i);
    }
};