class Solution {
public:
    vector<int> findRedundantDirectedConnection(vector<vector<int>>& edges) {
        
        int n = edges.size();
        vector<int> p(n + 1, 0), c(n + 1, 0), a, b, c;
        for (auto& e : edges) {
            if (c[e[1]] == 0) c[e[1]] = e[0];
            else {
                a = {c[e[1]], e[1]};
                b = {e[0], e[1]};
                e[1] = 0;
            }
            c[e[0]] = -1;
        }
        for (auto& e : edges) {
            if (e[1] == 0) continue;
            int x = find(p, e[0]), y = find(p, e[1]);
            if (x == y) {
                if (a.empty()) return e;
                else return a;
            }
            p[x] = y;
        }
        return b;
    }
};