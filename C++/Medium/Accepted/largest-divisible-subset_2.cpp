class Solution {
public:
    vector<int> largestDivisibleSubset(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> dp(n, 1);
        vector<int> parent(n, -1);
        sort(nums.begin(), nums.end());
        int max_idx = 0;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        parent[i] = j;
                    }
                }
            }
            if (dp[i] > dp[max_idx]) {
                max_idx = i;
            }
        }
        vector<int> res;
        while (max_idx != -1) {
            res.push_back(nums[max_idx]);
            max_idx = parent[max_idx];
        }
        return res;
    }
};