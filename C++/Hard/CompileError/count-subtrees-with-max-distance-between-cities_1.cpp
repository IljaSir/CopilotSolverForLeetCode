class Solution {
public:
    vector<int> countSubgraphsForEachDiameter(int n, vector<vector<int>>& edges) {
        
        vector<int> res(n - 1);
        vector<vector<int>> graph(n + 1);
        for (auto& e : edges) {
            graph[e[0]].push_back(e[1]);
            graph[e[1]].push_back(e[0]);
        }
        for (int i = 1; i < (1 << n); i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (i & (1 << (j - 1))) count++;
            }
            if (count < 2) continue;
            bool flag = true;
            for (int j = 1; j <= n; j++) {
                if (i & (1 << (j - 1))) {
                    for (int k = j + 1; k <= n; k++) {
                        if (i & (1 << (k - 1))) {
                            if (!check(graph, j, k, i)) {
                                flag = false;
                                break;
                            }
                        }
                    }
                }
                if (!flag) break;
            }
            if (!flag) continue;
            int max_dist = 0;
            for (int j = 1; j <= n; j++) {
                if (i & (1 << (j - 1))) {
                    int dist = 0;
                    dfs(graph, j, i, 0, dist);
                    max_dist = max(max_dist, dist);
                }
            }
            res[max_dist - 1]++;
        }
        return res;
    }
    void dfs(vector<vector<int>>& graph, int curr, int mask, int dist, int& max_dist) {
        max_dist = max(max_dist, dist);
        for (auto& next : graph[curr]) {
            if (mask & (1 << (next - 1))) {
                dfs(graph, next, mask, dist + 1, max_dist);
            }
        }
    }
};