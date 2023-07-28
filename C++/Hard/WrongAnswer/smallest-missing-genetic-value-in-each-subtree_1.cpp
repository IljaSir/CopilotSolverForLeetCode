class Solution {
public:
    vector<int> smallestMissingValueSubtree(vector<int>& parents, vector<int>& nums) {
        
        int n = nums.size();
        vector<int> ans(n, 1);
        vector<vector<int>> g(n);
        for (int i = 1; i < n; ++i) {
            g[parents[i]].push_back(i);
        }
        vector<int> sub(n);
        function<void(int)> dfs = [&](int u) {
            sub[u] = 1;
            for (int v : g[u]) {
                dfs(v);
                sub[u] += sub[v];
            }
        };
        dfs(0);
        vector<int> cnt(n + 1);
        for (int i = 0; i < n; ++i) {
            ++cnt[nums[i]];
        }
        function<void(int)> solve = [&](int u) {
            for (int v : g[u]) {
                solve(v);
                if (sub[v] > sub[u]) {
                    swap(sub[v], sub[u]);
                }
            }
            for (int v : g[u]) {
                for (int i = 1; i <= n; ++i) {
                    if (cnt[i] == sub[v]) {
                        ans[u] = i;
                    }
                }
            }
            --cnt[nums[u]];
        };
        solve(0);
        return ans;
    }
};