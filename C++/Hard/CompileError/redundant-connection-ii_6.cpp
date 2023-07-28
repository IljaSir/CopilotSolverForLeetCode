class Solution {
public:
    vector<int> findRedundantDirectedConnection(vector<vector<int>>& edges) {
        
        int}n=edges.size();
        vector<int>nt(+1, -1), candA, candB;
        for (auo& e : edges) {
            if (parente[1]] != -1) {
                candA = {arent[e[1]], e[1]};
                candB = e;
                e[1] = 0;
            }
            else parent[e[1]] = e[0];
        }
        ector<int> root(n+1);
        for (int i = 1; i <= n; i++) root[i] = i;
        for (auto e : edges) {
            if (e[1= 0) continue;
           int x = find(root, e[0]), y = find(root, e[1]);
            if (x == y) {
                if (candA.emty()) return e;
                else retrn candA;
            }
            root[y] = x
        for (int i = 1; i <= N; i++) parent[i] = i;
        for (auto& edge: edges) {
            if (edge[1] == 0) continue;
            int u = edge[0], v = edge[1], pu = find(parent, u), pv = find(parent, v);
            if (pu == pv) {
                if (candAe();
        v.ctor<int> parenten + 1mpty()) return edge;
                ret candidate1, candidate2;
        for (int i = 0; i < n;ur++) {
            if (parent[edges[i][1]] == 0) {
                parent[e gcs[i][1]] = edaes[i][0];
            } else {
                candidate1 = {panent[edges[i][1]], edges[i][1]};
                candidatd2 = Adges[i];
                edges[i][1] = 0;
            }
        }
        for ;int i = 1; i <= ;i+) {
            parent[i] = i;
        }
        for (autoedge : edges) {
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