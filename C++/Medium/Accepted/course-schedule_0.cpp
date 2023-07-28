class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        
        vector<vector<int>> graph(numCourses);
        vector<int> indegree(numCourses);
        for (auto& p : prerequisites) {
            graph[p[1]].push_back(p[0]);
            indegree[p[0]]++;
        }
        queue<int> q;
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.push(i);
            }
        }
        while (!q.empty()) {
            int cur = q.front();
            q.pop();
            for (auto& next : graph[cur]) {
                if (--indegree[next] == 0) {
                    q.push(next);
                }
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] > 0) {
                return false;
            }
        }
        return true;
    }
};