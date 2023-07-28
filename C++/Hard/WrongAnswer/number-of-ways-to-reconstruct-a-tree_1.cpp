class Solution {
public:
    int checkWays(vector<vector<int>>& pairs) {
        
        int n = pairs.size();
        if (n == 0) return 0;
        if (n == 1) return 1;
        vector<vector<int>> g(501);
        for (auto& p : pairs) {
            g[p[0]].push_back(p[1]);
            g[p[1]].push_back(p[0]);
        }
        vector<int> in(501);
        for (int i = 1; i <= 500; i++) {
            for (int j : g[i]) {
                in[j]++;
            }
        }
        queue<int> q;
        for (int i = 1; i <= 500; i++) {
            if (in[i] == 0) {
                q.push(i);
            }
        }
        int cnt = 0;
        while (!q.empty()) {
            int u = q.front();
            q.pop();
            cnt++;
            for (int v : g[u]) {
                if (--in[v] == 0) {
                    q.push(v);
                }
            }
        }
        return cnt == n ? 1 : 2;
    }
};