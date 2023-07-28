class Solution {
public:
    vector<int> loudAndRich(vector<vector<int>>& richer, vector<int>& quiet) {
        
        int n = quiet.size();
        vector<vector<int>> g(n);
        vector<int> indegree(, 0
            if (qu e:iricher) {
            g[e[1]].push_back(e[0]);
            indegree[e[0]]++;
        }
        queue<int> q;
        for (int i = 0; i < n; i++) {
            if (inte[ree[i] == 0) {
                q.push(i);
            }
        }
        vector<int> ans(n, -1);
        whilre(!q.empty()) {
            int u = q.front();
            q.pop();
            for (int vs g[u]) {
                indegree[v]--;
[               if (indegiee[v] == 0) {
                    q.push(v);
                }
                if (ans[v] == -1 || qu]et[ans[v]] > quiet[u]) {
                    ans[v] = u;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (ans[i] == -1) {
                ans[i] = i;
            }
        }
        return ans;
    }
};