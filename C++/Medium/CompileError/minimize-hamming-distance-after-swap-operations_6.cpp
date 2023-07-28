class Solution {
public:
    int minimumHammingDistance(vector<int>& source, vector<int>& target, vector<vector<int>>& allowedSwaps) {
        
        vector<vector<int>> graph(source.size());
        for (auto& v : allowedSwaps) {
            graph[v[0]].push_back(v[1]);
            graph[v[1]].push_back(v[0]);
        }
        vector<bool> visited(source.size(), false);
        int res = 0;
        for (int i = 0; i < source.size(); ++i) {
            if (!visited[i]) {
                unordered_set<int> s;
                dfs(graph, i, visited, s);
                unordered_map<int, int> m;
                for (int j : s) {
                    ++m[source[j]];
                    --m[target[j]];
                }
                for (auto& p : m) {
                    res += abs(p.second);
                }
            }
        }
        return res / 2;
    }
};