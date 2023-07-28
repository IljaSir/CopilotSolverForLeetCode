class Solution {
public:
    vector<int> findMinHeightTrees(int n, vector<vector<int>>& edges) {
        
        vector<vector<int>> adj(n);
        vector<int> degree(n);
        for (auto& edge : edges) {
            adj[edge[0]].push_back(edge[1]);
            adj[edge[1]].push_back(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        vector<int> leaves;
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                leaves.push_back(i);
            }
        }
        while (n > 2) {
            vector<int> newLeaves;
            for (auto& leaf : leaves) {
                for (auto& node : adj[leaf]) {
                    degree[node]--;
                    if (degree[node] == 1) {
                        newLeaves.push_back(node);
                    }
                }
            }
            leaves = newLeaves;
            n -= leaves.size();
        }
        return leaves;
    }
};