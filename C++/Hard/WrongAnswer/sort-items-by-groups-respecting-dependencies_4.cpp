class Solution {
public:
    vector<int> sortItems(int n, int m, vector<int>& group, vector<vector<int>>& beforeItems) {
        
        vector<vector<int>> g(n + m);
        vector<int> in(n + m, 0);
        for (int i = 0; i < n; ++i) {
            if (group[i] == -1) {
                group[i] = m++;
            }
            g[group[i]].push_back(i);
            ++in[i];
        }
        for (int i = 0; i < n; ++i) {
            for (int j : beforeItems[i]) {
                if (group[i] == group[j]) {
                    g[j].push_back(i);
                    ++in[i];
                }
                else {
                    g[group[j]].push_back(group[i]);
                    ++in[group[i]];
                }
            }
        }
        queue<int> q;
        for (int i = 0; i < m; ++i) {
            if (in[i] == 0) {
                q.push(i);
            }
        }
        vector<int> res;
        while (!q.empty()) {
            int t = q.front();
            q.pop();
            if (t < n) {
                res.push_back(t);
            }
            for (int i : g[t]) {
                --in[i];
                if (in[i] == 0) {
                    q.push(i);
                }
            }
        }
        return res.size() == m ? res : vector<int>();
    }
};