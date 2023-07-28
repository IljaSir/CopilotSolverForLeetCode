class Solution {
public:
    int minimumScore(vector<int>& nums, vector<vector<int>>& edges) {
        
        int n = nums.size();
        vector<vector<int>> g(n);
        for (auto& e : edges) {
            g[e[0]].push_back(e[1]);
            g[e[1]].push_back(e[0]);
        }
        vector<int> s(n);
        vector<int> p(n);
        function<void(int, int)> dfs = [&](int u, int pa) {
            s[u] = nums[u];
            p[u] = pa;
            for (int v : g[u]) {
                if (v != pa) {
                    dfs(v, u);
                    s[u] ^= s[v];
                }
            }
        };
        dfs(0, -1);
        int ans = INT_MAX;
        for (auto& e : edges) {
            int u = e[0], v = e[1];
            if (p[u] == v) swap(u, v);
            ans = min(ans, max(s[0], s[u] ^ s[v]));
        }
        return ans;
    }
};