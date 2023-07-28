class Solution {
public:
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
        
        vector<int> res;
        vector<int> indegree(numCourses, 0);
        vector<vector<int>> adj(numCourses);
        for (auto& p : prerequisites) {
            indegree[p[0]]++;
            adj[p[1]].push_back(p[0]);
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
            res.push_back(cur);
            for (auto& v : adj[cur]) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    q.push(v);
                }
            }
        }
        if (res.size() != numCourses) {
            return {};
        }
        return res;
    }
};