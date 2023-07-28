class Solution {
public:
    string findTheString(vector<vector<int>>& lcp) {
        
        int n = lcp.size();
        vector<vector<int>> adj(n);
        vector<int> indegree(n);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i != j && lcp[i][j] != n) {
                    adj[i].push_back(j);
                    ++indegree[j];
                }
            }
        }
        queue<int> q;
        for (int i = 0; i < n; ++i) {
            if (indegree[i] == 0) {
                q.push(i);
            }
        }
        string ans;
        while (!q.empty()) {
            int i = q.front();
            q.pop();
            ans.push_back('a' + i);
            for (int j : adj[i]) {
                --indegree[j];
                if (indegree[j] == 0) {
                    q.push(j);
                }
            }
        }
        return ans.size() == n ? ans : "";
    }
};