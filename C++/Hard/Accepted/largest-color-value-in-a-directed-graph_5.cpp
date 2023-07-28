class Solution {
public:
    int largestPathValue(string colors, vector<vector<int>>& edges) {
        
        int n = colors.size();
        vector<int> in(n, 0);
        vector<vector<int>> g(n, vector<int>(0));
        for (auto& e : edges) {
            g[e[0]].push_back(e[1]);
            ++in[e[1]];
        }
        vector<int> q;
        for (int i = 0; i < n; ++i) {
            if (in[i] == 0) {
                q.push_back(i);
            }
        }
        vector<int> f(n, 0);
        vector<vector<int>> cnt(n, vector<int>(26, 0));
        int ans = 0;
        for (int i = 0; i < q.size(); ++i) {
            int u = q[i];
            ++cnt[u][colors[u] - 'a'];
            for (int v : g[u]) {
                for (int j = 0; j < 26; ++j) {
                    cnt[v][j] = max(cnt[v][j], cnt[u][j]);
                }
                if (--in[v] == 0) {
                    q.push_back(v);
                }
            }
        }
        if (q.size() < n) {
            return -1;
        }
        for (int i = 0; i < n; ++i) {
            ans = max(ans, *max_element(cnt[i].begin(), cnt[i].end()));
        }
        return ans;
    }
};