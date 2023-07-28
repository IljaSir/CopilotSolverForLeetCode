class Solution {
public:
    vector<int> findAllPeople(int n, vector<vector<int>>& meetings, int firstPerson) {
        
        vector<int> ans;
        vector<int> g[n];
        vector<int> indegree(n, 0);
        vector<int> times(n, 0);
        for (auto m: meetings) {
            g[m[0]].push_back(m[1]);
            g[m[1]].push_back(m[0]);
            indegree[m[0]]++;
            indegree[m[1]]++;
            times[m[0]] = max(times[m[0]], m[2]);
            times[m[1]] = max(times[m[1]], m[2]);
        }
        queue<int> q;
        q.push(firstPerson);
        vector<bool> visited(n, false);
        visited[firstPerson] = true;
        while (!q.empty()) {
            int cur = q.front();
            q.pop();
            ans.push_back(cur);
            for (auto next: g[cur]) {
                indegree[next]--;
                if (indegree[next] == 0 && times[next] >= times[cur] && !visited[next]) {
                    q.push(next);
                    visited[next] = true;
                }
            }
        }
        return ans;
    }
};