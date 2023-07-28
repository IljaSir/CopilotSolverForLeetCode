class Solution {
public:
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
        
        vector<int> order;
        vector<int> inDegree(numCourses, 0);
        vector<vector<int>> outDegree(numCourses, vector<int>());
        for (auto pre: prerequisites) {
            inDegree[pre[0]]++;
            outDegree[pre[1]].push_back(pre[0]);
        }
        queue<int> q;
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.push(i);
            }
        }
        while (!q.empty()) {
            int course = q.front();
            q.pop();
            order.push_back(course);
            for (auto next: outDegree[course]) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    q.push(next);
                }
            }
        }
        if (order.size() != numCourses) {
            return {};
        }
        return order
            return result;
        }
        return {};
    }
};