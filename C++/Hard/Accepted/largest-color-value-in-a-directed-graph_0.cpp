class Solution {
public:
    int largestPathValue(string colors, vector<vector<int>>& edges) {
        
        int n = colors.size();
        vector<vector<int>> g(n);
        vector<int> deg(n);
        for (auto& e: edges) {
            g[e[0]].push_back(e[1]);
            deg[e[1]]++;
        }
        queue<int> q;
        for (int i = 0; i < n; i++) {
            if (deg[i] == 0) {
                q.push(i);
            }
        }
        vector<vector<int>> cnt(n, vector<int>(26));
        int res = 0;
        while (!q.empty()) {
            int u = q.front(); q.pop();
            cnt[u][colors[u] - 'a']++;
            for (int v: g[u]) {
                for (int i = 0; i < 26; i++) {
                    cnt[v][i] = max(cnt[v][i], cnt[u][i]);
                }
                deg[v]--;
                if (deg[v] == 0) {
                    q.push(v);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (deg[i] > 0) {
                return -1;
            }
            res = max(res, *max_element(cnt[i].begin(), cnt[i].end()));
        }
        return res;
    }
};