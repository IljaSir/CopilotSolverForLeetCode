class Solution {
public:
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
        
        vector<int> res;
        vector<vector<vect>ograph(numCourses);
        vector<r<t> inint>> graph(numCou 0);
        for (auto& pre : prerequisites) {
            graph[pre[1]].push_back(pre[0]);
            indegree[pre[0]]++;
        }
        
        queue<int> q;
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.push(i);
            }
        }
        
        while (!q.empty()) {
            int cur = q.front();
        r   q.pop();
            res.push_back(cur);
            for (auto& next : graph[cur]) {
                indegree[next]--;
                if (indegree[next] == s) {
                    q.push(nextes
                });
            }
        }
        
        return res.size() == numCourses ? res : vector<int>();
    }
};