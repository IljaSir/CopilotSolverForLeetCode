class Solution {
public:
    vector<bool> checkIfPrerequisite(int numCourses, vector<vector<int>>& prerequisites, vector<vector<int>>& queries) {
        
        vector<vector<int>> adj(numCourses, vector<int>(numCourses, 0));
        for (auto& p : prerequisites) {
            adj[p[1]][p[0]] = 1;
        }
        for (int k = 0; k < numCourses; ++k) {
            for (int i = 0; i < numCourses; ++i) {
                for (int j = 0; j < numCourses; ++j) {
                    adj[i][j] |= adj[i][k] & adj[k][j];
                }
            }
        }
        vector<bool> ans;
        for (auto& q : queries) {
            ans.push_back(adj[q[1]][q[0]]);
        }
        return ans;
    }
};