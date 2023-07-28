class Solution {
public:
    vector<int> findRedundantConnection(vector<vector<int>>& edges) {
        
        int n = edges.size();
        int *parent = new int[n + 1];
        for (int i = 1; i <= n; ++i) parent[i] = i;
        for (auto edge : edges) {
            int u = edge[0], v = edge[1];
            int pu = find(parent, u);
            int pv = find(parent, v);
            if (pu == pv) return edge;
            parent[pu] = pv;
        }
        return {};
    }
    int find(int *parent, int x) {
        if (parent[x] != x) parent[x] = find(parent, parent[x]);
        return parent[x];
    }
};