class Solution {
public:
    vector<int> eventualSafeNodes(vector<vector<int>>& graph) {
        
        int n = graph.size();
        vector<vector<int>> rg(n);
        vector<int> deg(n);
        for (int i = 0; i < n; i++) {
            for (int j : graph[i]) {
                rg[j].push_back(i);
            }
            deg[i] = graph[i].size();
        }
        queue<int> q;
        for (int i = 0; i < n; i++) {
            if (deg[i] == 0) {
                q.push(i);
            }
        }
        vector<int> ans;
        while (!q.empty()) {
            int u = q.front();
            q.pop();
            ans.push_back(u);
            for (int v : rg[u]) {
                if (--deg[v] == 0) {
                    q.push(v);
                }
            }
        }
        sort(ans.begin(), ans.end());
        return ans;
    }
};