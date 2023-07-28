class Solution {
public:
    int longestPath(vector<int>& parent, string s) {
        
        int n = parent.size();
        vector<vector<int>> children(n);
        for (int i = 1; i < n; ++i) {
            children[parent[i]].push_back(i);
        }
        int ans = 0;
        function<int(int, int)> dfs = [&](int u, int p) {
            int max1 = 0, max2 = 0;
            for (int v : children[u]) {
                if (v == p) continue;
                int len = dfs(v, u);
                if (s[u] != s[v]) {
                    if (max1 < len) {
                        max2 = max1;
                        max1 = len;
                    } else if (max2 < len) {
                        max2 = len;
                    }
                }
            }
            ans = max(ans, max1 + max2 + 1);
            return max1 + 1;
        };
        dfs(0, -1);
        return ans;
    }
};