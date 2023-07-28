class Solution {
public:
    vector<int> findRedundantDirectedConnection(vector<vector<int>>& edges) {
        
        int n = edges.size();
        vector<int> parent(n + 1);
        vector<int> candidate1, candidate2;
        for (int i = 0; i < n; i++) {
            if (parent[edges[i][1]] == 0) {
                parent[edges[i][1]] = edges[i][0];
            } else {
                candidate1 = {parent[edges[i][1]], edges[i][1]};
                candidate2 = edges[i];
                edges[i][1] = 0;
            }
        }
        for (int i = 1; i <= n; i++) {
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