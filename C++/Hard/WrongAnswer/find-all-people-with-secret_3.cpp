class Solution {
public:
    vector<int> findAllPeople(int n, vector<vector<int>>& meetings, int firstPerson) {
        
        vector<int> result;
        vector<int> visited(n, 0);
        vector<vector<int>> graph(n);
        for (int i = 0; i < meetings.size(); i++) {
            graph[meetings[i][0]].push_back(meetings[i][1]);
            graph[meetings[i][1]].push_back(meetings[i][0]);
        }
        queue<int> q;
        q.push(firstPerson);
        visited[firstPerson] = 1;
        while (!q.empty()) {
            int node = q.front();
            q.pop();
            result.push_back(node);
            for (int i = 0; i < graph[node].size(); i++) {
                if (visited[graph[node][i]] == 0) {
                    q.push(graph[node][i]);
                    visited[graph[node][i]] = 1;
                }
            }
        }
        return result;
    }
};