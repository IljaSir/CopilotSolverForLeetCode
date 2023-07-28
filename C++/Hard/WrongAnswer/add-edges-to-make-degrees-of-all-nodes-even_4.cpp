class Solution {
public:
    bool isPossible(int n, vector<vector<int>>& edges) {
        
        vector<vector<int>> adj(n);
        vector<int> degree(n);
        for (auto& e : edges) {
            adj[e[0] - 1].push_back(e[1] - 1);
            adj[e[1] - 1].push_back(e[0] - 1);
            degree[e[0] - 1]++;
            degree[e[1] - 1]++;
        }
        vector<int> odd;
        for (int i = 0; i < n; i++) {
            if (degree[i] % 2 == 1) {
                odd.push_back(i);
            }
        }
        if (odd.size() == 0) {
            return true;
        }
        if (odd.size() % 2 == 1) {
            return false;
        }
        for (int i = 0; i < odd.size(); i += 2) {
            bool found = false;
            for (int j = 0; j < adj[odd[i]].size(); j++) {
                if (degree[adj[odd[i]][j]] % 2 == 1) {
                    edges.push_back({odd[i] + 1, adj[odd[i]][j] + 1});
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return isPossible(n, edges);
    }
};