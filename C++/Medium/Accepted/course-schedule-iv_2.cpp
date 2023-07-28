class Solution {
public:
    vector<bool> checkIfPrerequisite(int numCourses, vector<vector<int>>& prerequisites, vector<vector<int>>& queries) {
        
        vector<vector<bool>> reachable(numCourses, vector<bool>(numCourses, false));
        for (auto &p : prerequisites) {
            reachable[p[0]][p[1]] = true;
        }
        for (int k = 0; k < numCourses; ++k) {
            for (int i = 0; i < numCourses; ++i) {
                for (int j = 0; j < numCourses; ++j) {
                    reachable[i][j] = reachable[i][j] || (reachable[i][k] && reachable[k][j]);
                }
            }
        }
        vector<bool> ans;
        for (auto &q : queries) {
            ans.push_back(reachable[q[0]][q[1]]);
        }
        return ans;
    }
};