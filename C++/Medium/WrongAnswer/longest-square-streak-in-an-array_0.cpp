class Solution {
public:
    int longestSquareStreak(vector<int>& nums) {
        
        int n = nums.size();
        unordered_map<int, int> mp;
        for (int i = 0; i < n; i++) {
            mp[nums[i]] = i;
        }
        sort(nums.begin(), nums.end());
        vector<int> dp(n, 1);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[j] % nums[i] == 0 && mp.count(nums[j] / nums[i])) {
                    dp[j] = max(dp[j], dp[i] + 1);
                }
            }
        }
        return *max_element(dp.begin(), dp.end()) >= 2 ? *max_element(dp.begin(), dp.end()) : -1;
    }
};