class Solution {
public:
    int maximalNetworkRank(int n, vector<vector<int>>& roads) {
        
        vector<int> adj[n];
        int deg[n];
        memset(deg, 0, sizeof(deg));
        for (auto road : roads) {
            int a = road[0], b = road[1];
            deg[a]++;
            deg[b]++;
            adj[a].push_back(b);
            adj[b].push_back(a);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                res = max(res, deg[i] + deg[j] - (find(adj[i].begin(), adj[i].end(), j) != adj[i].end()));
            }
        }
        return res;
    }
};