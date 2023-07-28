class Solution {
public:
    vector<int> largestDivisibleSubset(vector<int>& nums) {
        
        int n = nums.size();
        if (n == 0)
            return {};
        sort(nums.begin(), nums.end());
        vector<int> dp(n, 1);
        vector<int> pre(n, -1);
        int maxIdx = 0;
        for (int i = 1; i < n; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    pre[i] = j;
                }
            }
            if (dp[i] > dp[maxIdx])
                maxIdx = i;
        }
        vector<int> ans;
        while (maxIdx != -1) {
            ans.push_back(nums[maxIdx]);
            maxIdx = pre[maxIdx];
        }
        return ans;
    }
};