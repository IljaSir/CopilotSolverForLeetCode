class Solution {
public:
    int longestPath(vector<int>& parent, string s) {
        
        int n = parent.size();
        vector<vector<int>> children(n);
        for (int i = 1; i < n; ++i) {
            children[parent[i]].push_back(i);
        }
        int res = 0;
        function<int(int, int)> dfs = [&](int u, int p) {
            int mx1 = 0, mx2 = 0;
            for (int v : children[u]) {
                if (v == p) continue;
                int len = dfs(v, u);
                if (s[v] != s[u]) len++;
                if (len > mx1) {
                    mx2 = mx1;
                    mx1 = len;
                } else if (len > mx2) {
                    mx2 = len;
                }
            }
            res = max(res, mx1 + mx2);
            return mx1;
        };
        dfs(0, -1);
        return res;
    }
};