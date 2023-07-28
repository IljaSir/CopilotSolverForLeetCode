class Solution {
public:
    vector<int> restoreArray(vector<vector<int>>& adjacentPairs) {
        
        unordered_map<int, vector<int>> graph;
        for (auto& pair: adjacentPairs) {
            graph[pair[0]].push_back(pair[1]);
            graph[pair[1]].push_back(pair[0]);
        }
        int n = adjacentPairs.size() + 1;
        vector<int> ans(n);
        for (auto& [v, adj]: graph) {
            if (adj.size() == 1) {
                ans[0] = v;
                break;
            }
        }
        ans[1] = graph[ans[0]][0];
        for (int i = 2; i < n; i++) {
            auto& adj = graph[ans[i - 1]];
            ans[i] = ans[i - 2] == adj[0] ? adj[1] : adj[0];
        }
        return ans;
    }
};