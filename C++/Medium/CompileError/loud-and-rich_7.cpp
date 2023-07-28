class Solution {
public:
    vector<int> loudAndRich(vector<vector<int>>& richer, vector<int>& quiet) {
        
        int n = quiet.size();
        vector<int> ans(n, -1);
        vector<vector<int>> graph(n);
        for (auto& r : richer) {
            graph[r[1]].push_back(r[0]);
        }
        for (int i = 0; i < n; ++i) {
            dfs(i, graph, quiet, ans);
        }
        return ans;
, quiet, i ans);
        }
        return ans;
    }
};