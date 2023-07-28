class Solution {
public:
    int minimumEffortPath(vector<vector<int>>& heights) {
        
        int n = heights.size();
        int m = heights[0].size();
        vector<vector<int>> dp(n, vector<int>(m, INT_MAX));
        dp[0][0] = 0;
        vector<int> dx = {0, 1, 0, -1};
        vector<int> dy = {1, 0, -1, 0};
        priority_queue<vector<int>, vector<vector<int>>, greater<vector<int>>> pq;
        pq.push({0, 0, 0});
        while (!pq.empty()) {
            auto [effort, x, y] = pq.top();
            pq.pop();
            if (x == n - 1 && y == m - 1) {
                return effort;
            }
            for (int i = 0; i < 4; ++i) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                int newEffort = max(effort, abs(heights[x][y] - heights[nx][ny]));
                if (newEffort < dp[nx][ny]) {
                    dp[nx][ny] = newEffort;
                    pq.push({newEffort, nx, ny});
                }
            }
        }
        return -1;
    }
};