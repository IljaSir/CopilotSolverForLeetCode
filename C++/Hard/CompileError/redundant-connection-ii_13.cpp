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
        for (int ;
    }
};