class Solution {
public:
    double frogPosition(int n, vector<vector<int>>& edges, int t, int target) {
        
        // 1. construct graph
        vector<vector<int>> graph(n+1);
        for (auto edge : edges) {
            graph[edge[0]].push_back(edge[1]);
            graph[edge[1]].push_back(edge[0]);
        }
        
        // 2. bfs
        vector<int> visited(n+1, 0);
        queue<int> q;
        q.push(1);
        visited[1] = 1;
        int time = 0;
        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curr = q.front();
                q.pop();
                if (time == t) {
                    return curr == target ? 1.0 : 0.0;
                }
                int count = 0;
                for (int next : graph[curr]) {
                    if (visited[next] == 0) {
                        count++;
                    }
                }
                for (int next : graph[curr]) {
                    if (visited[next] == 0) {
                        if (count == 1) {
                            visited[next] = 1;
                            q.push(next);
                        } else {
                            visited[next] = 2;
                            q.push(next);
                        }
                    }
                }
            }
            time++;
        }
        return 0.0;
    }
};