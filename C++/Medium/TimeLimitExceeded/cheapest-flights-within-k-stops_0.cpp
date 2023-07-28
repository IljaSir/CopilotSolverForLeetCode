class Solution {
public:
    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int k) {
        
        vector<vector<pair<int, int>>> graph(n);
        for (auto &f : flights) {
            graph[f[0]].push_back({f[1], f[2]});
        }
        priority_queue<vector<int>, vector<vector<int>>, greater<vector<int>>> pq;
        pq.push({0, src, k + 1});
        while (!pq.empty()) {
            auto top = pq.top();
            pq.pop();
            int cost = top[0], city = top[1], stops = top[2];
            if (city == dst) return cost;
            if (stops > 0) {
                for (auto &v : graph[city]) {
                    pq.push({cost + v.second, v.first, stops - 1});
                }
            }
        }
        return -1;
    }
};