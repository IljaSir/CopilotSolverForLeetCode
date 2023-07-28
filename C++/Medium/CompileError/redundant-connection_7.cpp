class Solution {
public:
    vector<int> findRedundantConnection(vector<vector<int>>& edges) {
        
        int n = edges.size();
        vector<int> parent(n+1);
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
        for (auto& e : edges) {
            int u = e[0];
            int v = e[1];
            int pu = find(parent, u);
            int pv = find(parent, v);
            if (pu == pv) return e;
            parent[pu] = pv;
        }
        return {};
    }
};