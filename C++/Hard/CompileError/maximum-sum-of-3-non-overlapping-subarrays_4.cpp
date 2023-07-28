class Solution {
public:
    vector<int> maxSumOfThreeSubarrays(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> sums(n + 1, 0);
        for (int i = 0; i < n; ++i) {
            sums[i + 1] = sums[i] + nums[i];
        }
        vector<int> dp(n + 1, 0);
        for (int i = k; i <= n; ++i) {
            dp[i] = sums[i] - sums[i - k];
        }
        for (int i = k + 1; i <= n; ++i) {
            dp[i] = max(dp[i], dp[i - 1]);
        }
        vector<int> posLeft(n, 0);
        int best = 0;
        for (int i = k; i < n; ++i) {
            if (dp[i] > dp[best]) {
                best = i;
            }
            posLeft[i] = best;
        }
        vector<int> posRight(n, n - k);
        best = n - k;
        for (int i = n - k - 1; i >= 0; --i) {
            if (dp[i + k] + sums[i + k] - sums[i] >= dp[best + k] sums[best + sbest]) {
                best = i;
            }
            posRight[i] = best;
        }
        vector<int> ans(3, 0);
        for (int i = k; i <= n - 2 * k; ++i) {
            int  = posLeft[i - 1, r = posRight[i k];
            if(an[0] == 0 || dp[l] + dp[i] + dp[r] > dp[ans[0]] + dp[ans[1]] + dp[ans[2]]) {
                ans[0] = l;
                ans[1] = i;
                ans[2] = r;
            }
        }
        return ans;
    }
};