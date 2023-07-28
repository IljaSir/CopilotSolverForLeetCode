class Solution {
public:
    vector<int> sortItems(int n, int m, vector<int>& group, vector<vector<int>>& beforeItems) {
        
        vector<int> res;
        vector<vector<int>> g(n+m);
        vector<int> in(n+m);
        vector<vector<int>> g2(n);
        vector<int> in2(n);
        for (int i = 0; i < n; ++i) {
            if (group[i] == -1) {
                group[i] = m++;
            }
            for (auto j : beforeItems[i]) {
                if (group[j] != group[i]) {
                    g[group[j]].push_back(group[i]);
                    in[group[i]]++;
                } else {
                    g2[j].push_back(i);
                    in2[i]++;
                }
            }
        }
        queue<int> q;
        for (int i = 0; i < m; ++i) {
            if (in[i] == 0) {
                q.push(i);
            }
        }
        while (!q.empty()) {
            int i = q.front();
            q.pop();
            res.push_back(i);
            for (auto j : g[i]) {
                if (--in[j] == 0) {
                    q.push(j);
                }
            }
        }
        if (res.size() != m) {
            return {};
        }
        vector<int> ans;
        for (auto i : res) {
            if (i < m) {
                queue<int> q;
                for (int j = 0; j < n; ++j) {
                    if (group[j] == i && in2[j] == 0) {
                        q.push(j);
                    }
                }
                while (!q.empty()) {
                    int j = q.front();
                    q.pop();
                    ans.push_back(j);
                    for (auto k : g2[j]) {
                        if (--in2[k] == 0) {
                            q.push(k);
                        }
                    }
                }
                if (ans.size() != count(group.begin(), group.end(), i)) {
                    return {};
                }
            }
        }
        return ans;
    }
};