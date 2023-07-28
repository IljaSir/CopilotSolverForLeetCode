class Solution {
public:
    vector<bool> checkIfPrerequisite(int numCourses, vector<vector<int>>& prerequisites, vector<vector<int>>& queries) {
        
        vector<vector<bool>> dp(numCourses, vector<bool>(numCourses, false));
        for (int i = 0; i < prerequisites.size(); i++) {
            dp[prerequisites[i][1]][prerequisites[i][0]] = true;
        }
        for (int k = 0; k < numCourses; k++) {
            for (int i = 0; i < numCourses; i++) {
                for (int j = 0; j < numCourses; j++) {
                    dp[i][j] = dp[i][j] || (dp[i][k] && dp[k][j]);
                }
            }
        }
        vector<bool> ans;
        for (int i = 0; i < queries.size(); i++) {
            ans.push_back(dp[queries[i][1]][queries[i][0]]);
        }
        return ans;
    }
};