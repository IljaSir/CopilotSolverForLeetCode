class Solution {
public:
    int minCost(vector<int>& startPos, vector<int>& homePos, vector<int>& rowCosts, vector<int>& colCosts) {
        
        int m = rowCosts.size();
        int n = colCosts.size();
        auto cmp = [](vector<int> a, vector<int> b) { return a[2] > b[2]; };
        priority_queue<vector<int>, vector<vector<int>>, decltype(cmp)> pq(cmp);
        vector<vector<int>> costs(m, vector<int>(n, INT_MAX));
        pq.push({startPos[0], startPos[1], 0});
        costs[startPos[0]][startPos[1]] = 0;
        while (!pq.empty()) {
            auto [x, y, cost] = pq.top(); pq.pop();
            if (x == homePos[0] && y == homePos[1]) return cost;
            if (x > 0) {
                int newCost = cost + rowCosts[x];
                if (newCost < costs[x - 1][y]) {
                    costs[x - 1][y] = newCost;
                    pq.push({x - 1, y, newCost});
                }
            }
            if (x < m - 1) {
                int newCost = cost + rowCosts[x + 1];
                if (newCost < costs[x + 1][y]) {
                    costs[x + 1][y] = newCost;
                    pq.push({x + 1, y, newCost});
                }
            }
            if (y > 0) {
                int newCost = cost + colCosts[y];
                if (newCost < costs[x][y - 1]) {
                    costs[x][y - 1] = newCost;
                    pq.push({x, y - 1, newCost});
                }
            }
            if (y < n - 1) {
                int newCost = cost + colCosts[y + 1];
                if (newCost < costs[x][y + 1]) {
                    costs[x][y + 1] = newCost;
                    pq.push({x, y + 1, newCost});
                }
            }
        }
        return 0;
    }
};