class Solution {
public:
    int minCost(int maxTime, vector<vector<int>>& edges, vector<int>& passingFees) {
        
        int n = passingFees.size();
        vector<vector<pair<int, int>>> g(n);
        for (auto &e : edges) {
            g[e[0]].push_back(make_pair(e[1], e[2]));
            g[e[1]].push_back(make_pair(e[0], e[2]));
        }
        vector<vector<int>> dp(n, vector<int>(maxTime + 1, INT_MAX));
        dp[0][0] = passingFees[0];
        priority_queue<pair<int, pair<int, int>>, vector<pair<int, pair<int, int>>>, greater<pair<int, pair<int, int>>>> pq;
        pq.push(make_pair(passingFees[0], make_pair(0, 0)));
        while (!pq.empty()) {
            auto p = pq.top();
            pq.pop();
            int cost = p.first, city = p.second.first, time = p.second.second;
            if (cost > dp[city][time]) continue;
            for (auto &e : g[city]) {
                int city2 = e.first, time2 = e.second;
                if (time + time2 > maxTime) continue;
                if (dp[city][time] + passingFees[city2] < dp[city2][time + time2]) {
                    dp[city2][time + time2] = dp[city][time] + passingFees[city2];
                    pq.push(make_pair(dp[city2][time + time2], make_pair(city2, time + time2)));
                }
            }
        }
        int ans = INT_MAX;
        for (int i = 0; i <= maxTime; ++i) {
            ans = min(ans, dp[n - 1][i]);
        }
        return ans == INT_MAX ? -1 : ans;
    }
};