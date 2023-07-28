class Solution {
public:
    long long taskSchedulerII(vector<int>& tasks, int space) {
        
        int n = tasks.size();
        vector<vector<int>> pos(n + 1);
        for (int i = 0; i < n; i++) {
            pos[tasks[i]].push_back(i);
        }
        vector<long long> dp(n + 1);
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + space + 1;
            for (int j = 1; j <= n; j++) {
                if (pos[j].empty()) continue;
                auto it = upper_bound(pos[j].begin(), pos[j].end(), i - space - 1);
                if (it == pos[j].begin()) continue;
                --it;
                dp[i] = min(dp[i], dp[*it + 1] + i - *it - 1);
            }
        }
        return dp[n];
    }
};