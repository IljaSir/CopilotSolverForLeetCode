class Solution {
public:
    vector<bool> checkIfPrerequisite(int numCourses, vector<vector<int>>& prerequisites, vector<vector<int>>& queries) {
        
        vector<vector<int>> g(numCourses, vector<int>(numCourses, 0));
        for (auto& p: prerequisites) {
            g[p[0]][p[1]] = 1;
        }
        for (int i = 0; i < numCourses; i++) {
            for (int j = 0; j < numCourses; j++) {
                for (int k = 0; k < numCourses; k++) {
                    if (g[j][i] && g[i][k]) {
                        g[j][k] = 1;
                    }
                }
            }
        }
        vector<bool> res;
        for (auto& q: queries) {
            res.push_back(g[q[0]][q[1]]);
        }
        return res;
    }
};