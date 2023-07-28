class Solution {
public:
    int largestPathValue(string colors, vector<vector<int>>& edges) {
        
        int n = colors.size();
        vector<vector<int>> g(n);
        vector<int> deg(n);
        for (auto& e : edges) {
            int u = e[0], v = e[1];
            g[u].push_back(v);
            deg[v]++;
        }
        vector<int> q;
        for (int i = 0; i < n; i++) {
            if (deg[i] == 0) {
                q.push_back(i);
            }
        }
        for (int i = 0; i < q.size(); i++) {
            int u = q[i];
            for (auto& v : g[u]) {
                if (--deg[v] == 0) {
                    q.push_back(v);
                }
            }
        }
        if (q.size() < n) {
            return -1;
        }
        vector<int> f(n, 1);
        vector<vector<int>> cnt(n, vector<int>(26));
        for (int i = n - 1; i >= 0; i--) {
            int u = q[i];
            cnt[u][colors[u] - 'a'] = f[u];
            for (auto& v : g[u]) {
                for (int c = 0; c < 26; c++) {
                    cnt[u][c] = max(cnt[u][c], cnt[v][c]);
                }
                f[u] = max(f[u], f[v] + 1);
            }
        }
        return *max_element(f.begin(), f.end());
    }
};