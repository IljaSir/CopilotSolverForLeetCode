class Solution {
public:
    vector<int> eventualSafeNodes(vector<vector<int>>& graph) {
        
        int n = graph.size();
        vector<int> degree(n,0);
        vector<vector<int>> out(n);
        for (int i = 0; i < n; i++) {
            degree[i] = graph[i].size();
            for (int j = 0; j < graph[i].size(); j++) {
                out[graph[i][j]].push_back(i);
            }
        }
        vector<int> ans;
        queue<int> q;
        for (int i = 0; i < n; i++) {
            if (degree[i] == 0) {
                q.push(i);
            }
        }
        while (!q.empty()) {
            int u = q.front();
            q.pop();
            ans.push_back(u);
            for (int i = 0; i < out[u].size(); i++) {
                int v = out[u][i];
                degree[v]--;
                if (degree[v] == 0) {
                    q.push(v);
                }
            }
        }
        sort(ans.begin(), ans.end());
        return ans;
    }
};