class Solution {
public:
    long long minimumWeight(int n, vector<vector<int>>& edges, int src1, int src2, int dest) {
        
        vector<vector<pair<int, long long>>> adj(n);
        for (auto& e : edges) {
            adj[e[0]].emplace_back(e[1], e[2]);
        }
        vector<long long> dist1(n, LLONG_MAX), dist2(n, LLONG_MAX);
        dijkstra(adj, dist1, src1);
        dijkstra(adj, dist2, src2);
        long long res = LLONG_MAX;
        for (auto& e : edges) {
            if (dist1[e[0]] == LLONG_MAX || dist2[e[0]] == LLONG_MAX || dist1[e[1]] == LLONG_MAX || dist2[e[1]] == LLONG_MAX) {
                continue;
            }
            long long cur = dist1[e[0]] + dist2[e[0]] + e[2] + dist1[e[1]] + dist2[e[1]];
            if (e[0] == src1 && e[1] == src2) {
                cur -= e[2];
            }
            if (e[0] == src2 && e[1] == src1) {
                cur -= e[2];
            }
            res = min(res, cur);
        }
        return res == LLONG_MAX ? -1 : res;
    }
};