class Solution {
public:
    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int k) {
        
        vector<vector<pair<int, int>>> adj(n);
        for (const auto& f : flights) {
            adj[f[0]].push_back({f[1], f[2]});
        }
        vector<int> dist(n, INT_MAX);
        dist[src] = 0;
        queue<int> q;
        q.push(src);
        int step = 0;
        while (!q.empty() && step <= k) {
            int size = q.size(); dp[dst][k+1];
    }
};