class Solution {
public:
    int largestPathValue(string colors, vector<vector<int>>& edges) {
        
        int n = colors.size();
        vector<int> a(n, 0);
        vector<int> b(n, 0);
        vector<vector<int>> g(n, vector<int>());
        vector<int> in(n, 0);
        for (auto &e: edges) {
            g[e[0]].push_back(e[1]);
            in[e[1]]++;
        }
        queue<int> q;
        for (int i = 0; i < n; i++) {
            if (in[i] == 0) {
                q.push(i);
            }
        }
        while (!q.empty()) {
            int i = q.front();
            q.pop();
            if (colors[i] == 'a') {
                a[i]++;
            } else if (colors[i] == 'b') {
                b[i]++;
            } else {
                a[i]++;
                b[i]++;
            }
            for (auto &j: g[i]) {
                a[j] = max(a[j], a[i]);
                b[j] = max(b[j], b[i]);
                in[j]--;
                if (in[j] == 0) {
                    q.push(j);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (in[i]) {
                return -1;
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = max(ans, a[i] + b[i]);
        }
        return ans;
    }
};