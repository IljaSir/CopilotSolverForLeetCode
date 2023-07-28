class Solution {
public:
    vector<int> gardenNoAdj(int n, vector<vector<int>>& paths) {
        
        vector<vector<int>> adj(n);
        for (auto& p : paths) {
            adj[p[0] - 1].push_back(p[1] - 1);
            adj[p[1] - 1].push_back(p[0] - 1);
        }
        vector<int> ans(n);
        for (int i = 0; i < n; ++i) {
            vector<bool> used(5);
            for (auto& j : adj[i]) {
                used[ans[j]] = true;
            }
            for (int j = 1; j <= 4; ++j) {
                if (!used[j]) {
                    ans[i] = j;
                    break;
                }
            }
        }
        return ans;
    }
};