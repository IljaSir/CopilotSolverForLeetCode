class Solution {
public:
    vector<int> findRedundantDirectedConnection(vector<vector<int>>& edges) {
        
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