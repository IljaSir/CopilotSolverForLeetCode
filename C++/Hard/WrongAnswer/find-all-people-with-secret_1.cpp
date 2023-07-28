class Solution {
public:
    vector<int> findAllPeople(int n, vector<vector<int>>& meetings, int firstPerson) {
        
        vector<vector<int>> graph(n);
        vector<int> inDegree(n, 0);
        for (auto m : meetings) {
            graph[m[0]].push_back(m[1]);
            graph[m[1]].push_back(m[0]);
            ++inDegree[m[0]];
            ++inDegree[m[1]];
        }
        vector<int> ans;
        queue<int> q;
        q.push(firstPerson);
        while (!q.empty()) {
            int cur = q.front();
            q.pop();
            ans.push_back(cur);
            for (auto next : graph[cur]) {
                if (--inDegree[next] == 0) {
                    q.push(next);
                }
            }
        }
        return ans;
    }
};