class Solution {
public:
    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int k) {
        
        vector<vector<int>> dist(n, vector<int>(k+2, INT_MAX));
        dist[src][0] = 0;
        for (int i = 1; i <= k+1; i++) {
            for (auto& e : flights) {
                if (dist[e[0]][i-1] != INT_MAX) {
                    dist[e[1]][i] = min(dist[e[1]][i], dist[e[0]][i-1] + e[2]);
                }
            }
        }
        int res = INT_MAX;
        for (int i = 1; i <= k+1; i++) {
            res = min(res, dist[dst][i]);
        }
        return res == INT_MAX ? -1 : res;
    }
};