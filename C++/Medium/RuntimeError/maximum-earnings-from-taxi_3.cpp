class Solution {
public:
    long long maxTaxiEarnings(int n, vector<vector<int>>& rides) {
        
        vector<vector<int>> sorted;
        for (int i = 0; i < rides.size(); ++i) {
            sorted.push_back({rides[i][1], rides[i][0], rides[i][2], i});
        }
        sort(sorted.begin(), sorted.end());
        vector<int> dp(sorted.size(), 0);
        dp[0] = sorted[0][2] + sorted[0][0] - sorted[0][1];
        for (int i = 1; i < sorted.size(); ++i) {
            int l = 0, r = i;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (sorted[mid][0] <= sorted[i][1]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            dp[i] = max(dp[i - 1], sorted[i][2] + sorted[i][0] - sorted[i][1] + (l > 0 ? dp[l - 1] : 0));
        }
        return dp.back();
    }
};