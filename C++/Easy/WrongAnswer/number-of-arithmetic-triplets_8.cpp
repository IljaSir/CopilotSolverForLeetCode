class Solution {
public:
    int arithmeticTriplets(vector<int>& nums, int diff) {
        
        int n = nums.size();
        vector<int> dp(n, 0);
        unordered_map<int, int> m;
        for (int i = 0; i < n; i++) {
            m[nums[i]] = i;
            if (m.find(nums[i] - diff) != m.end()) {
                dp[i] = dp[m[nums[i] - diff]] + 1;
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (m.find(nums[i] + diff) != m.end()) {
                res += dp[i];
            }
        }
        return res;
    }
};