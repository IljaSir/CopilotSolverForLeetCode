class Solution {
public:
    int minimumScore(vector<int>& nums, vector<vector<int>>& edges) {
        
        int n = nums.size();
        vector<vector<int>> adj(n);
        for (auto& e : edges) {
            adj[e[0]].push_back(e[1]);
            adj[e[1]].push_back(e[0]);
        }
        vector<int> sub(n);
        int ans = INT_MAX;
        function<void(int, int)> dfs = [&](int u, int p) {
            sub[u] = nums[u];
            for (int v : adj[u]) {
                if (v == p) continue;
                dfs(v, u);
                sub[u] ^= sub[v];
            }
            if (p != -1) ans = min(ans, sub[u] ^ sub[p]);
        };
        dfs(0, -1);
        return ans;
    }
};