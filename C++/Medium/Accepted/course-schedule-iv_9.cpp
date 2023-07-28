class Solution {
public:
    vector<bool> checkIfPrerequisite(int numCourses, vector<vector<int>>& prerequisites, vector<vector<int>>& queries) {
        
        vector<bool> res;
        vector<vector<bool>> graph(numCourses, vector<bool>(numCourses, false));
        for (auto &e : prerequisites) {
            graph[e[0]][e[1]] = true;
        }
        for (int k = 0; k < numCourses; ++k) {
            for (int i = 0; i < numCourses; ++i) {
                for (int j = 0; j < numCourses; ++j) {
                    graph[i][j] = graph[i][j] || (graph[i][k] && graph[k][j]);
                }
            }
        }
        for (auto &e : queries) {
            res.push_back(graph[e[0]][e[1]]);
        }
        return res;
    }
};