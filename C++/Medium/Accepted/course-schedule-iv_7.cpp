class Solution {
public:
    vector<bool> checkIfPrerequisite(int numCourses, vector<vector<int>>& prerequisites, vector<vector<int>>& queries) {
        
        vector<vector<int>> graph(numCourses, vector<int>(numCourses, 0));
        for (auto& e: prerequisites) {
            graph[e[0]][e[1]] = 1;
        }
        for (int i = 0; i < numCourses; ++i) {
            graph[i][i] = 1;
        }
        for (int k = 0; k < numCourses; ++k) {
            for (int i = 0; i < numCourses; ++i) {
                for (int j = 0; j < numCourses; ++j) {
                    graph[i][j] = graph[i][j] || (graph[i][k] && graph[k][j]);
                }
            }
        }
        vector<bool> ans;
        for (auto& q: queries) {
            ans.push_back(graph[q[0]][q[1]]);
        }
        return ans;
    }
};