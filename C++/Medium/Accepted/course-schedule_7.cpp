class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        
        vector<vector<int>> graph(numCourses);
        vector<int> inDegree(numCourses, 0);
        for (auto& edge : prerequisites) {
            graph[edge[1]].push_back(edge[0]);
            ++inDegree[edge[0]];
        }
        queue<int> q;
        for (int i = 0; i < numCourses; ++i) {
            if (inDegree[i] == 0) {
                q.push(i);
            }
        }
        int visited = 0;
        while (!q.empty()) {
            int v = q.front();
            q.pop();
            ++visited;
            for (int u : graph[v]) {
                --inDegree[u];
                if (inDegree[u] == 0) {
                    q.push(u);
                }
            }
        }
        return visited == numCourses;
    }
};