class Solution {
public:
    int longestSquareStreak(vector<int>& nums) {
        
        int n = nums.size();
        unordered_map<int, int> m;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            m[nums[i]] = 1;
            if (m.find(nums[i] * nums[i]) != m.end()) {
                m[nums[i]] = m[nums[i] * nums[i]] + 1;
                ans = max(ans, m[nums[i]]);
            }
            if (nums[i] % sqrt(nums[i]) == 0 && m.find(nums[i] / sqrt(nums[i])) != m.end()) {
                m[nums[i]] = m[nums[i] / sqrt(nums[i])] + 1;
                ans = max(ans, m[nums[i]]);
            }
        }
        return ans;
    }
};