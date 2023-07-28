class Solution {
public:
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
        
        vector<int> result;
        vector<vector<int>> graph(numCourses);
        vector<int> indegree(numCourses);
        for (auto& pre : prerequisites) {
            graph[pre[1]].push_back(pre[0]);
            ++indegree[pre[0]];
        }
        queue<int> q;
        for (int i = 0; i < numCourses; ++i) {
            if (indegree[i] == 0) {
                q.push(i);
            }
        }
        while (!q.empty()) {
            int node = q.front();
            q.pop();
            result.push_back(node);
            for (auto& neighbor : graph[node]) {
                --indegree[neighbor];
                if (indegree[neighbor] == 0) {
                    q.push(neighbor);
                }
            }
        }
        if (result.size() == numCourses) { vector<int>();
    }
};