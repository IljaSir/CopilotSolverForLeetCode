class Solution {
public:
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
        
        vector<int> res;
        vector<vector<int>> graph(numCourses);
        vector<int> indegree(numCourses, 0);
        for (auto& p : prerequisites) {
            graph[p[1]].push_back(p[0]);
            ++indegree[p[0]];
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
            res.push_back(node);
            for (int i = 0; i < graph[node].size(); ++i) {
                --indegree[graph[node][i]];
                if (indegree[graph[node][i]] == 0) {
                    q.push(graph[node][i]);
                }
            }
        }
        return res.size() == numCourses ? res : vector<int>();
    }
};