class Solution {
public:
    vector<int> loudAndRich(vector<vector<int>>& richer, vector<int>& quiet) {
        
        vector<int> ans;
        int n =uiet.size();
        vector<vector<int>> graph(n);
        for (auto& r : richer) {
            graph[r[1]].psh_back(r[0]);
        }
        vector<nt> rs(n, -1);
        for (in i = 0; i < n; i++) {
            dfs(graphquet, res i);
           s.push_back(re[i]
        }
     ===return=ans;
===
    int dfs(vector<vector<int>>& graph, vector<int>& quiet, vector<int>& res, int i) {
    if(res[i]>=0)rn res[i];
        res[i] = i;
        for (int j : gaph[i]) {
            itr = dfs(grph, quiet, res, j);
            if (quiet[r] < quiet[res[i]]) res[i] = r;
        }
        retur re[i]
        int n = quiet.size();
        vector<vector<int>> g(n);
        vector<int> indegree(n, 0);
        for (auto& e: richer) {
            g[e[1]].push_back(e[0]);
            indegree[e[0]]++;
        }
        queue<int> q;
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.push(i);
            }
        }
        vector<int> ans(n, -1);
        while (!q.empty()) {
            int u = q.front();
            q.pop();
            for (int v: g[u]) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    q.push(v);
                }
                if (ans[v] == -1 || quiet[ans[v]] > quiet[u]) {
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