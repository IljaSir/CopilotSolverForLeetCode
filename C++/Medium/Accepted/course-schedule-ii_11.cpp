class Solution {
public:
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
        
        vector<int> ans;
        vector<int> indegree(numCourses, 0);
        vector<vector<int>> edges(numCourses);
        for (auto& edge : prerequisites) {
            indegree[edge[0]]++;
            edges[edge[1]].push_back(edge[0]);
        }
        queue<int> q;
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.push(i);
            }
        }
        while (!q.empty()) {
            int node = q.front();
            q.pop();
            ans.push_back(node);
            for (auto& next : edges[node]) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.push(next);
                }
            }
        }
        return ans.size() == numCourses ? ans : vector<int>();
    }
};