class Solution {
public:
    vector<int> findRedundantConnection(vector<vector<int>>& edges) {
        
        int n = edges.size();
        vector<int> parent(n + 1);
        for (int i = 0; i <= n; ++i) {
            parent[i] = i;
        }
        for (auto& edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (find(parent, u) == find(parent, v)) {
                return edge;
            }
            parent[find(parent, u)] = find(parent, v);
        }
        return {};
    }
};