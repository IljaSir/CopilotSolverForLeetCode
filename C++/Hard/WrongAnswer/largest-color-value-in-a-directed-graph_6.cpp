class Solution {
public:
    int largestPathValue(string colors, vector<vector<int>>& edges) {
        
        int n = colors.size();
        vector<vector<int>> adj(n);
        vector<int> indeg(n, 0);
        vector<vector<int>> cnt(n, vector<int>(26, 0));
        for (auto& e : edges) {
            adj[e[0]].push_back(e[1]);
            indeg[e[1]]++;
        }
        queue<int> q;
        for (int i = 0; i < n; i++) {
            if (indeg[i] == 0) {
                q.push(i);
                cnt[i][colors[i] - 'a'] = 1;
            }
        }
        while (!q.empty()) {
            int u = q.front();
            q.pop();
            for (int v : adj[u]) {
                indeg[v]--;
                for (int i = 0; i < 26; i++) {
                    cnt[v][i] = max(cnt[v][i], cnt[u][i]);
                }
                cnt[v][colors[v] - 'a']++;
                if (indeg[v] == 0) {
                    q.push(v);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (indeg[i] > 0) {
                return -1;
            }
            for (int j = 0; j < 26; j++) {
                res = max(res, cnt[i][j]);
            }
        }
        return res;
    }
};