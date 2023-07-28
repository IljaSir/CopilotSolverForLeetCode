class Solution {
public:
    int arithmeticTriplets(vector<int>& nums, int diff) {
        
        int n = nums.size();
        int res = 0;
        vector<int> dp(n, 0);
        unordered_map<int, int> m;
        for (int i = 0; i < n; i++) {
            if (m.count(nums[i] - diff)) {
                dp[i] += m[nums[i] - diff];
            }
            if (m.count(nums[i])) {
                m[nums[i]] += dp[i];
            } else {
                m[nums[i]] = dp[i];
            }
            res += dp[i];
        }
        return res;
    }
};