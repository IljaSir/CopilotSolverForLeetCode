class Solution {
public:
    int longestPath(vector<int>& parent, string s) {
        
        int n = parent.size();
        vector<vector<int>> children(n);
        for (int i = 1; i < n; ++i) {
            children[parent[i]].push_back(i);
        }
        int ans = 0;
        function<int(int, int)> dfs = [&](int u, int c) {
            int res = 0;
            for (int v: children[u]) {
                if (s[v] == c) continue;
                res = max(res, dfs(v, s[v]));
            }
            ans = max(ans, res + 1);
            return res + 1;
        };
        dfs(0, s[0]);
        return ans - 1;
    }
};