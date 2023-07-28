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
        return bi = 1; i <= n; i++) {
            parent[i] = i;
        }
        for (auto edge : edges) {
            if (edge[1] == 0) {
                continue;
            }
            int u = edge[0], v = edge[1];
            int pu = find(parent, u), pv = find(parent, v);
            if (pu == pv) {
                if (candidate1.empty()) {
                    return edge;
                } else {
                    return candidate1;
                }
            }
            parent[pv] = pu;
        }
        return candidate2;
    }
    int find(vector<int>& parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }
};