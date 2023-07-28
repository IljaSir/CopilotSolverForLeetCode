class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        
        vector<vector<int>> graph(numCourses);
        for (auto p: prerequisites) {
            graph[p[1]].push_back(p[0]);
        }
        vector<int> visited(numCourses, 0);
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0 && !dfs(graph, visited, i)) {
                return false;
            }
        }
        return true;
    }
    bool dfs(vector<vector<int>>& graph, vector<int>& visited, int i) {
        visited[i] = 1;
        for (auto j: graph[i]) {
            if (visited[j] == 1 || (visited[j] == 0 && !dfs(graph, visited, j))) {
                return false;
            }
        }
        visited[i] = 2;
        return true;
    }
};