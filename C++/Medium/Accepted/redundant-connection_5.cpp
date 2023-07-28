class Solution {
public:
    vector<int> findRedundantConnection(vector<vector<int>>& edges) {
        
        vector<int> parent(edges.size() + 1);
        for (int i = 0; i < parent.size(); i++)
            parent[i] = i;
        
        for (int i = 0; i < edges.size(); i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            
            if (find(parent, x) == find(parent, y))
                return edges[i];
            
            parent[find(parent, x)] = find(parent, y);
        }
        
        return vector<int>();
    }
    
    int find(vector<int>& parent, int x) {
        if (parent[x] != x)
            parent[x] = find(parent, parent[x]);
        
        return parent[x];
    }
};