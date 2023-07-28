class Solution {
public:
    int minSubArrayLen(int target, vector<int>& nums) {
        
        int n = nums.size(), ans = INT_MAX, sum = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            while (sum >= target) {
                ans = min(ans, i - j + 1);
                sum -= nums[j++];
            }
        }
        return ans == INT_MAX ? 0 : ans;
    }
};