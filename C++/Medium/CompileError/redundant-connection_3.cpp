class Solution {
public:
    vector<int> findRedundantConnection(vector<vector<int>>& edges) {
        
        vector<int> parent(edges.size() + 1, 0);
        for (int i = 1; i <= edges.size(); ++i) {
            parent[i] = i;
        }
        for (auto& edge : edges) {
            int root1 = find(parent, edge[0]);
            int root2 = find(parent, edge[1]);
            if (root1 == root2) {
                return edge;
            }
            parent[root1] = root2;
        }
        return {};
    }
};