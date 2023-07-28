class Solution {
public:
    int minimumEffortPath(vector<vector<int>>& heights) {
        
        int m = heights.size(), n = heights[0].size();
        vector<vector<int>> dp(m, vector<int>(n, INT_MAX));
        dp[0][0] = 0;
        vector<vector<int>> dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        priority_queue<vector<int>, vector<vector<int>>, greater<vector<int>>> pq;
        pq.push({0, 0, 0});
        while(!pq.empty()) {
            auto node = pq.top();
            pq.pop();
            int i = node[1], j = node[2];
            if (i == m-1 && j == n-1) return node[0];
            for (auto d : dir) {
                int x = i + d[0], y = j + d[1];
                if (x < 0 || x >= m || y < 0 || y >= n) continue;
                int newEffort = max(node[0], abs(heights[i][j] - heights[x][y]));
                if (dp[x][y] > newEffort) {
                    dp[x][y] = newEffort;
                    pq.push({newEffort, x, y});
                }
            }
        }
        return -1;
    }
};