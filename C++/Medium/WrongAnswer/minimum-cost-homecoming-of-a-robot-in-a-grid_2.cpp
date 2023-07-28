class Solution {
public:
    int minCost(vector<int>& startPos, vector<int>& homePos, vector<int>& rowCosts, vector<int>& colCosts) {
        
        int m = rowCosts.size();
        int n = colCosts.size();
        vector<vector<int>> dp(m, vector<int>(n, INT_MAX));
        dp[startPos[0]][startPos[1]] = 0;
        priority_queue<pair<int, pair<int, int>>, vector<pair<int, pair<int, int>>>, greater<pair<int, pair<int, int>>>> pq;
        pq.push({0, {startPos[0], startPos[1]}});
        while (!pq.empty()) {
            auto [cost, pos] = pq.top(); pq.pop();
            int r = pos.first;
            int c = pos.second;
            if (r + 1 < m && dp[r + 1][c] > cost + rowCosts[r + 1]) {
                dp[r + 1][c] = cost + rowCosts[r + 1];
                pq.push({dp[r + 1][c], {r + 1, c}});
            }
            if (c + 1 < n && dp[r][c + 1] > cost + colCosts[c + 1]) {
                dp[r][c + 1] = cost + colCosts[c + 1];
                pq.push({dp[r][c + 1], {r, c + 1}});
            }
            if (r - 1 >= 0 && dp[r - 1][c] > cost + rowCosts[r]) {
                dp[r - 1][c] = cost + rowCosts[r];
                pq.push({dp[r - 1][c], {r - 1, c}});
            }
            if (c - 1 >= 0 && dp[r][c - 1] > cost + colCosts[c]) {
                dp[r][c - 1] = cost + colCosts[c];
                pq.push({dp[r][c - 1], {r, c - 1}});
            }
        }
        return dp[homePos[0]][homePos[1]];
    }
};