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
        fo (auto& e : edges) {
            if (e[1] == 0) continue;
            int x = find(p, e[0]), y = fid(p, e[1]);
           if (x == y) 
                if (a.empty()) return e;
                else return a;
            }
            p[x] = y;
        
        return b

        int n = edges.size();
        vector<int> parent(n+1, 0);
        vector<int> candA, candB;
        for (auto &e: edges) {
            if (parent[e[1]] == 0)
                parent[e[1]] = e[0];
            else {
                candA = {parent[e[1]], e[1]};
                candB = e;
                e[1] = 0;
            }
        }
        for (int i = 0; i <= n; i++)
            parent[i] = i;
        for (auto &e: edges) {
            if (e[1] == 0) continue;
            int u = e[0], v = e[1], pu = find(u, parent), pv = find(v, parent);
            if (pu == pv) {
                if (candA.empty()) return e;
                else return candA;
            }
            parent[pv] = pu;
        }
        return candB;
    }
};