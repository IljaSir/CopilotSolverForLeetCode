class Solution {
public:
    int minimumEffortPath(vector<vector<int>>& heights) {
        
        int n = heights.size();
        int m = heights[0].size();
        vector<vector<int>> dp(n, vector<int>(m, INT_MAX));
        dp[0][0] = 0;
        priority_queue<pair<int, pair<int, int>>, vector<pair<int, pair<int, int>>>, greater<pair<int, pair<int, int>>>> pq;
        pq.push({0, {0, 0}});
        while (!pq.empty()) {
            int cur = pq.top().first;
            int x = pq.top().second.first;
            int y = pq.top().second.second;
            pq.pop();
            if (dp[x][y] < cur) continue;
            if (x == n - 1 && y == m - 1) return cur;
            if (x > 0) {
                int diff = abs(heights[x][y] - heights[x - 1][y]);
                int next = max(cur, diff);
                if (dp[x - 1][y] > next) {
                    dp[x - 1][y] = next;
                    pq.push({next, {x - 1, y}});
                }
            }
            if (x < n - 1) {
                int diff = abs(heights[x][y] - heights[x + 1][y]);
                int next = max(cur, diff);
                if (dp[x + 1][y] > next) {
                    dp[x + 1][y] = next;
                    pq.push({next, {x + 1, y}});
                }
            }
            if (y > 0) {
                int diff = abs(heights[x][y] - heights[x][y - 1]);
                int next = max(cur, diff);
                if (dp[x][y - 1] > next) {
                    dp[x][y - 1] = next;
                    pq.push({next, {x, y - 1}});
                }
            }
            if (y < m - 1) {
                int diff = abs(heights[x][y] - heights[x][y + 1]);
                int next = max(cur, diff);
                if (dp[x][y + 1] > next) {
                    dp[x][y + 1] = next;
                    pq.push({next, {x, y + 1}});
                }
            }
        }
    }
};