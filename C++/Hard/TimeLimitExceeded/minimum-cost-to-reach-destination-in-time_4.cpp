class Solution {
public:
    int minCost(int maxTime, vector<vector<int>>& edges, vector<int>& passingFees) {
        
        int n = passingFees.size();
        vector<vector<pair<int, int>>> graph(n);
        for (auto& edge : edges) {
            graph[edge[0]].push_back({edge[1], edge[2]});
            graph[edge[1]].push_back({edge[0], edge[2]});
        }
        vector<vector<int>> dp(n, vector<int>(maxTime + 1, INT_MAX));
        dp[0][0] = passingFees[0];
        priority_queue<tuple<int, int, int>, vector<tuple<int, int, int>>, greater<tuple<int, int, int>>> pq;
        pq.push({passingFees[0], 0, 0});
        while (!pq.empty()) {
            auto [cost, city, time] = pq.top();
            pq.pop();
            if (dp[city][time] < cost) {
                continue;
            }
            for (auto& [next, nextTime] : graph[city]) {
                if (time + nextTime <= maxTime) {
                    if (dp[next][time + nextTime] > cost + passingFees[next]) {
                        dp[next][time + nextTime] = cost + passingFees[next];
                        pq.push({dp[next][time + nextTime], next, time + nextTime});
                    }
                }
            }
        }
        int ans = INT_MAX;
        for (int time = 1; time <= maxTime; ++time) {
            ans = min(ans, dp[n - 1][time]);
        }
        return ans == INT_MAX ? -1 : ans;
    }
};