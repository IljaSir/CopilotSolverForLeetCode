class Solution {
public:
    vector<int> findRedundantConnection(vector<vector<int>>& edges) {
        
        vector<int> parent(edges.size() + 1, 0);
        for (int i = 0; i < parent.size(); i++) {
            parent[i] = i;
        }
        for (auto& edge : edges) {
            int p1 = find(parent, edge[0]);
            int p2 = find(parent, edge[1]);
            if (p1 == p2) {
                return edge;
            }
            parent[p1] = p2;
        }
        return {};
    }
    int find(vector<int>& parent, int node) {
        if (parent[node] == node) {
            return node;
        }
        return parent[node] = find(parent, parent[node]);
    }
};