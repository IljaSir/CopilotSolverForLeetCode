class Solution {
public:
    vector<int> findAllPeople(int n, vector<vector<int>>& meetings, int firstPerson) {
        
        vector<vector<int>> graph(n);
        for (vector<int>& meeting: meetings) {
            graph[meeting[0]].push_back(meeting[1]);
            graph[meeting[1]].push_back(meeting[0]);
        }
        vector<int> res;
        vector<int> visited(n, 0);
        queue<int> q;
        q.push(firstPerson);
        while (!q.empty()) {
            int cur = q.front();
            q.pop();
            if (visited[cur] == 0) {
                res.push_back(cur);
                visited[cur] = 1;
                for (int& next: graph[cur]) {
                    q.push(next);
                }
            }
        }
        return res;
    }
};