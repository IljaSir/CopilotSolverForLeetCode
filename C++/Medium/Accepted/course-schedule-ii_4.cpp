class Solution {
public:
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
        
        vector<int> ans;
        vector<vector<int>> graph(numCourses);
        vector<int> indegrees(numCourses, 0);
        for (auto& p : prerequisites) {
            graph[p[1]].push_back(p[0]);
            indegrees[p[0]]++;
        }
        queue<int> q;
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                q.push(i);
            }
        }
        while (!q.empty()) {
            int node = q.front();
            q.pop();
            ans.push_back(node);
            for (int v : graph[node]) {
                indegrees[v]--;
                if (indegrees[v] == 0) {
                    q.push(v);
                }
            }
        }
        if (ans.size() != numCourses) {
            ans.clear();
        }
        return ans;
    }
};