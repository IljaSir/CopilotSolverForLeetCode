class Solution {
public:
    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int k) {
        
        vector<vector<pair<int, int>>> graph(n);
        for (auto& e : flights) {
            graph[e[0]].push_back({e[1], e[2]});
        }
        priority_queue<vector<int>, vector<vector<int>>, greater<vector<int>>> pq;
        pq.push({0, src, k + 1});
        while (!pq.empty()) {
            auto t = pq.top(); pq.pop();
            int price = t[0], city = t[1], stops = t[2];
            if (city == dst) return price;
            if (stops > 0) {
                for (auto& e : graph[city]) {
                    pq.push({price + e.second, e.first, stops - 1});
                }
            }
        }
        return -1;
    }
};