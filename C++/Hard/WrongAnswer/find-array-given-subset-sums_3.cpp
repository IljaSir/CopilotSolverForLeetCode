class Solution {
public:
    vector<int> recoverArray(int n, vector<int>& sums) {
        
        int sz = sums.size();
        vector<int> ans(n, 0);
        if (sz == 0) return ans;
        sort(sums.begin(), sums.end());
        vector<int> dp(sz, 0);
        int i, j;
        for (i = 0; i < sz; i++) {
            for (j = i - 1; j >= 0; j--) {
                if (sums[i] - sums[j] == dp[j]) {
                    dp[i] = sums[i] - dp[j];
                    break;
                }
            }
            if (j == -1) {
                dp[i] = sums[i];
            }
        }
        for (i = 0; i < n; i++) {
            ans[i] = dp[sz - 1] - dp[sz - 1 - (1 << i)];
        }
        return ans;
    }
};