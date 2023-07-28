class Solution {
public:
    long long maxTaxiEarnings(int n, vector<vector<int>>& rides) {
        
        int M = rides.size();
        vector<pair<int, int>> v;
        for (int i = 0; i < M; i++) {
            v.emplace_back(rides[i][1], i);
        }
        sort(v.begin(), v.end());
        vector<int> dp(M+1, 0);
        int j = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i-1];
            while (j < M && v[j].first == i) {
                int k = v[j].second;
                int start = rides[k][0];
                dp[i] = max(dp[i], dp[start] + rides[k][1] - start + rides[k][2]);
                j++;
            }
        }
        return dp[n];
    }
};