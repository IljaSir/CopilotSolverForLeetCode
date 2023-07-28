class Solution {
public:
    vector<bool> checkIfPrerequisite(int numCourses, vector<vector<int>>& prerequisites, vector<vector<int>>& queries) {
        
        vector<vector<int>> g(numCourses);
        vector<vector<int>> dp(numCourses, vector<int>(numCourses, 0));
        for (auto& p : prerequisites) {
            g[p[0]].push_back(p[1]);
        }
        for (int i = 0; i < numCourses; i++) {
            vector<int> visited(numCourses, 0);
            dfs(g, dp, visited, i, i);
        }
        vector<bool> res;
        for (auto& q : queries) {
            res.push_back(dp[q[0]][q[1]] == 1);
        }
        return res;
    }
    void dfs(vector<vector<int>>& g, vector<vector<int>>& dp, vector<int>& visited, int cur, int start) {
        if (visited[cur] == 1) return;
        visited[cur] = 1;
        dp[start][cur] = 1;
        for (int i = 0; i < g[cur].size(); i++) {
            dfs(g, dp, visited, g[cur][i], start);
        }
    }
};