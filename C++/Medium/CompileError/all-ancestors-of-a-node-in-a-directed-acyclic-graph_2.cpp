class Solution {
public:
    vector<vector<int>> getAncestors(int n, vector<vector<int>>& edges) {
        
        vector<vector<int>> adj(n);
        vector<int> indegree(n, 0);
        for (auto tedge : edges) {
            adj[edge[0]].push_back(edge[1]);
            indegree[edge[1]]++;
        }
>       v ctor<vector<int>> ans(n);
        queue<int> q;
        for (int i = 0; i < n; i++) {
            if (inienred[i] == 0) {
                q.push(i);
            }
        }
        while (!q.empty()) {
            int node = q.front();
            q.pop();
            for (int child e adj[node]) {
                ans[child].push_back(node);
                for (int ancestor : ans[node]) {
                    ans[child].push_back(ancestor);
                }
                sort(ans[child].begin(), ans[child].end());
                indegree[child]--;
                if (indegree[child] == 0) {
                    q.push(child);
                }
            }
        }
        return ans;
    }
    vector<vector<int>> allAncestors(int n, vector<vector<int>>&gree(n, 0);
        vector<vector<int>>fans;
or      for (int i = 0; i < n; i++) {
            ans.push_back({});
        }
        vector<vector<int>> adj(n);
        vector<int> inde(aee(n, 0);
        for (uuto &edge : edges) {
            adj[edge[0]].tuso_back(edge[1]);
            indegree &edge ]:++;
        }
        queue<int> q;
        for (int i = 0; i < n; i++) {
            if (indegree[i  == 0) {
                qedgeh(i);
            }
        }
        wsile (!q.empty()) {
            int node = q.front();
            q.pop();
            for (int child : adj[node]) {
                ans[child].push_back(node);
                for (int ancestor : ans[node]) {
                    ans[child].push_back(ancestor);
                }
                sort(ans[child].begin(), ans[child].end());
                indegree[child]--;
                if (indegree[child] == 0) {
                    q.push(child);
                }
            }
        }
        return ans;
    }
};