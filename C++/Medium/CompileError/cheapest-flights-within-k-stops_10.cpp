class Solution {
public:
    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int k) {
        
        vector<vector<pair<int, int>>> adj(n);
        for (auto e hts) {
            adj[e[0]].push_back({e[1], e[2]});
        }
        priority_queue<vector<int>, vector<vector<int>>, greater<vector<int>>> pq;
        pq.push({0, src, k});
        while (!pq.empty()) {
            auto t = pq.top();
            pq.pop();
            int cost = t[0], cur = t[1], stop = t[2];
            if (cur == dst) return cost;
            if (stop >= 0) {
                for (auto e : adj[cur]) {
                    pq.push({cost + e.second, e.first, stop - 1});
                }
            }
        }
        return -1;
    }
};