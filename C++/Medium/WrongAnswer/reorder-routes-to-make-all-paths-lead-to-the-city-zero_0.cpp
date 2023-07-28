class Solution {
public:
    int minReorder(int n, vector<vector<int>>& connections) {
        
        vector<vector<int>> graph(n);
        for (auto& c : connections) {
            graph[c[0]].push_back(c[1]);
            graph[c[1]].push_back(-c[0]);
        }
        int ans = 0;
        queue<int> Q;
        Q.push(0);
        vector<bool> visited(n);
        while (!Q.empty()) {
            int curr = Q.front();
            Q.pop();
            if (visited[curr]) continue;
            visited[curr] = true;
            for (int next : graph[curr]) {
                if (next < 0) {
                    next = -next;
                    ans++;
                }
                Q.push(next);
            }
        }
        return ans;
    }
};