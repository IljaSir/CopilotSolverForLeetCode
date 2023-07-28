class Solution {
public:
    long long maximumImportance(int n, vector<vector<int>>& roads) {
        
        vector<vector<int>> graph(n);
        for (auto &road : roads) {
            graph[road[0]].push_back(road[1]);
            graph[road[1]].push_back(road[0]);
        }
        vector<int> visited(n, 0);
        vector<int> values(n, 0);
        function<void(int, int)> dfs = [&](int node, int value) {
            visited[node] = 1;
            values[node] = value;
            for (auto &next : graph[node]) {
                if (visited[next]) continue;
                dfs(next, value + 1);
            }
        };
        dfs(0, 1);
        long long res = 0;
        for (auto &road : roads) {
            res += values[road[0]] + values[road[1]];
        }
        return res;
    }
};