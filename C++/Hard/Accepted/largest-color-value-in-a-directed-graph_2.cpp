class Solution {
public:
    int largestPathValue(string colors, vector<vector<int>>& edges) {
        
        int n = colors.size();
        vector<int> indegree(n, 0);
        vector<vector<int>> graph(n, vector<int>());
        for (auto& edge : edges) {
            graph[edge[0]].push_back(edge[1]);
            indegree[edge[1]]++;
        }
        queue<int> q;
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) q.push(i);
        }
        vector<vector<int>> dp(n, vector<int>(26, 0));
        while (!q.empty()) {
            int node = q.front();
            q.pop();
            dp[node][colors[node] - 'a']++;
            for (int nei : graph[node]) {
                indegree[nei]--;
                if (indegree[nei] == 0) q.push(nei);
                for (int i = 0; i < 26; i++) {
                    dp[nei][i] = max(dp[nei][i], dp[node][i]);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (indegree[i] != 0) return -1;
            ans = max(ans, *max_element(dp[i].begin(), dp[i].end()));
        }
        return ans;
    }
};