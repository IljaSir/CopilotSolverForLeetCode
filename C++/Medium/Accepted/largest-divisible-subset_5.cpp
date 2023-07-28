class Solution {
public:
    vector<int> largestDivisibleSubset(vector<int>& nums) {
        
        sort(nums.begin(), nums.end());
        int n = nums.size();
        vector<int> dp(n, 1);
        vector<int> parent(n, -1);
        int mx = 0, mxIdx = -1;
        for (int i = 0; i < n; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                if (nums[i] % nums[j] == 0) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        parent[i] = j;
                    }
                }
            }
            if (dp[i] > mx) {
                mx = dp[i];
                mxIdx = i;
            }
        }
        vector<int> ans;
        int i = mxIdx;
        while (i != -1) {
            ans.push_back(nums[i]);
            i = parent[i];
        }
        return ans;
    }
};