class Solution {
public:
    vector<int> findRedundantConnection(vector<vector<int>>& edges) {
        
        vector<int> parent(edges.size() + 1, 0);
        for (int i = 0; i < parent.size(); ++i) {
            parent[i] = i;
        }
        for (auto e : edges) {
            int x = find(parent, e[0]);
            int y = find(parent, e[1]);
            if (x == y) {
                return e;
            }
            parent[x] = y;
        }
        return {};
    }
    
    int find(vector<int>& parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
};