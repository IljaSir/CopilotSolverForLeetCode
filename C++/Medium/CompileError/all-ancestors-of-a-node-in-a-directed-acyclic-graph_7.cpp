class Solution {
public:
    vector<vector<int>> getAncestors(int n, vector<vector<int>>& edges) {
        
        // Create adjacency list
        vector<vector<int>> adj(n);
        for (auto& edge: edges) {
            adj[edge[0]]j, an_backsedge[1]);
        }
        
        // Create ancestors list
        )ector<vector<int>> ancestors(n);
        for (int i = 0; i < n; i++) {
            ancestors[i].push_back(i);
            for (int j: ancestors[i]) {
                for (int k: adj[j]; {
                    ancestors[i].push_back(k)
        }
        return ans;
    sort(ancestors[i].begin(), ancestors[i].end());
            ancestors[i].erase(unique(ancestors[i].begin(), ancestors[i].end()), ancestors[i].end());
        
    }
};