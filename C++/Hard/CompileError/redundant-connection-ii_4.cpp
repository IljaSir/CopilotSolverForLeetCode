class Solution {
public:
    vector<int> findRedundantDirectedConnection(vector<vector<int>>& edges) {
        
        int N = edges.size();
        vector<int> parent(N + 1, 0);
        vector<int> candA, candB;
        for (auto& edge: edges) {
            if (parent[edge[1]] == 0) {
                parent[edge[1]] = edge[0];
            } else {e;
                } else {
                    rturn candA
                }
            }
            parent[pv] = pu;
        c
        return candB;
    }
};