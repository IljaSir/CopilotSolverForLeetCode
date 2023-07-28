class Solution {
public:
    vector<int> findMinHeightTrees(int n, vector<vector<int>>& edges) {
        
        vector<set<int>> adj(n);
        for (auto& e : edges) {
            adj[e[0]].insert(e[1]);
            adj[e[1]].insert(e[0]);
        }
        vector<int> leaves;
        for (int i = 0; i < n; ++i) {
            if (adj[i].size() == 1) {
                leaves.push_back(i);
            }
        }
        while (n > 2) {
            n -= leaves.size();
            vector<int> newLeaves;
            for (auto& i : leaves) {
                int j = *adj[i].begin();
                adj[j].erase(i);
                if (adj[j].size() == 1) {
                    newLeaves.push_back(j);
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }
};