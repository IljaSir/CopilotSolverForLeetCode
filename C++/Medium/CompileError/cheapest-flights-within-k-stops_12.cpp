class Solution {
public:
    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int k) {
        
        const int INmpty()) {
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