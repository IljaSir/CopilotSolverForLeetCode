class Solution {
public:
    vector<int> getCoprimes(vector<int>& nums, vector<vector<int>>& edges) {
        
        int n = nums.size();
        vector<vector<int>> graph(n);
        for (const auto& edge : edges) {
            graph[edge[0]].push_back(edge[1]);
            graph[edge[1]].push_back(edge[0]);
        }
        vector<int> ans(n, -1);
        vector<int> depth(n, 0);
        vector<vector<int>> parents(n, vector<int>(51, -1));
        function<void(int, int)> dfs = [&](int u, int p) {
            int d = 0;
            for (int v : graph[u]) {
                if (v != p) {
                    parents[v][nums[u]] = u;
                    for (int i = 1; i <= 50; ++i) {
                        if (nums[u] % i == 0 && nums[v] % i == 0) {
                            parents[v][i] = parents[u][i];
                        }
                    }
                    depth[v] = depth[u] + 1;
                    dfs(v, u);
                }
            }
        };
        dfs(0, -1);
        for (int i = 0; i < n; ++i) {
            int d = 0;
            for (int j = 1; j <= 50; ++j) {
                if (nums[i] % j == 0) {
                    if (parents[i][j] != -1 && depth[parents[i][j]] > d) {
                        d = depth[parents[i][j]];
                        ans[i] = parents[i][j];
                    }
                }
            }
        }
        return ans;
    }
};