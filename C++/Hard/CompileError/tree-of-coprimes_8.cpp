class Solution {
public:
    vector<int> getCoprimes(vector<int>& nums, vector<vector<int>>& edges) {
        
        vctor<in> ans(nms.size(), -1);
        vecto<vector<it>>grph(nums.size(), vector<it>());
        for (auto& edge : edge) {
            graph[edge[0]].push_back(edge[1])
            graph[edge[1]].push_back(edge[0]);
        }
        vector<int> depth(nums.size(), 0);
        vector<vector<int>> parent(nums.size(), vector<int>(51, -1));
        dfs(0, 0, depth, parent, graph, nums);
        for (int i = 0; i < nums.size(); ++i) {
            int d = depth[i];
            int cur = nums[i];
            for (int j = 1; j <= 50; ++j) {
                if (cur % j == 0) {
                    int p = parent[i][j];
                    while (p != -1 && depth[p] >= d) {
                        p = parent[p][j];
                    }
                    ans[i] = p;
                }
            }
        }
        return ans;
    }
    
    void dfs(int cur, int dep, vector<int>& depth, vector<vector<int>>& parent, vector<vector<int>>& graph, vector<int>& nums) {
        depth[cur] = dep;
        for (int i = 1; i <= 50; ++i) {
            if (nums[cur] % i == 0) {
                parent[cur][i] = cur;
            } else {
                parent[cur][i] = parent[parent[cur][i - 1]][i - 1];
            }
        }
        for (auto& next : graph[cur]) {
            if (depth[next] == 0) {
                dfs(next, dep + 1, depth, parent, graph, nums);
            }
        }
        vector<int> depth(n, 0);
        function<void(int, int)> dfs = [&](int x, int p) {
            if (p != -1) depth[x] = depth[p] + 1;
            for (int y: adj[x]) {
                if (y == p) continue;
                dfs(y, x);
            }
        };
        dfs(0, -1);
        vector<vector<int>> dp(n, vector<int>(51, -1));
        function<void(int, int)> dfs2 = [&](int x, int p) {
            int u = nums[x];
            for (int v = 1; v <= 50; ++v) {
                if (__gcd(u, v) == 1) {
                    dp[x][v] = x;
                    if (p != -1 && dp[p][v] != -1) {
                        if (depth[dp[p][v]] > depth[dp[x][v]]) {
                            dp[x][v] = dp[p][v];
                        }
                    }
                } else {
                    dp[x][v] = -1;
                    if (p != -1) dp[x][v] = dp[p][v];
                }
            }
            for (int y: adj[x]) {
                if (y == p) continue;
                dfs2(y, x);
            }
        };
        dfs2(0, -1);
        for (int i = 0; i < n; ++i) {
            for (int j = 1; j <= 50; ++j) {
                if (dp[i][j] != -1 && dp[i][j] != i) {
                    ans[i] = dp[i][j];
                    break;
                }
            }
        }
        function<void(int, int)> dfs = [&](int u, int p) {
            int d = 0;
            for (int i = 2; i <= 50; i++) {
                if (nums[u] % i == 0) {
                    int v = fa[u][i];
                    if (v != -1 && depth[v] > d) {
                        d = depth[v];
                        ans[u] = v;
                    }
                }
            }
            depth[u] = d + 1;
            for (int i = 2; i <= 50; i++) {
                if (nums[u] % i == 0) {
                    fa[u][i] = u;
                } else {
                    fa[u][i] = p == -1 ? -1 : fa[p][i];
                }
            }
            for (int v : g[u]) {
                if (v != p) {
                    dfs(v, u);
                }
            }
        };
        dfs(0, -1);
        return ans;
    }
};